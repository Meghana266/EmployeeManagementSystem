package com.employwise.employeemanagement.service;

import com.employwise.employeemanagement.model.Employee;
import com.employwise.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(String id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getNthLevelManager(String id, String level) {
        // Parse the level parameter to an integer
        int nthLevel;
        try {
            nthLevel = Integer.parseInt(level);
        } catch (NumberFormatException e) {
            // Log the error or provide more context in the exception message
            e.printStackTrace();
            return Optional.empty();
        }
    
        // Initialize the employee ID and level manager
        String employeeId = id;
        Employee manager = null;
    
        // Iterate through the employee hierarchy up to the desired level
        while (nthLevel > 0 && !StringUtils.isEmpty(employeeId)) {
            // Retrieve the employee by ID
            Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
            if (employeeOptional.isPresent()) {
                // Get the reporting manager ID
                String reportsToId = employeeOptional.get().getReportsTo();
                if (!StringUtils.isEmpty(reportsToId)) {
                    // Retrieve the reporting manager by ID
                    Optional<Employee> managerOptional = employeeRepository.findById(reportsToId);
                    if (managerOptional.isPresent()) {
                        manager = managerOptional.get();
                    }
                }
                // Move to the next level
                employeeId = reportsToId;
                nthLevel--;
            } else {
                // Employee not found, return empty optional
                return Optional.empty();
            }
        }
    
        // Return the nth level manager (or null if not found)
        return Optional.ofNullable(manager);
    }
}