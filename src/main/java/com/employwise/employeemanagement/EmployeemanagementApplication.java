package com.employwise.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EmployeemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeemanagementApplication.class, args);
    }
}
