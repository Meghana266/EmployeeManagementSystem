package com.employwise.employeemanagement.repository;

import com.employwise.employeemanagement.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
