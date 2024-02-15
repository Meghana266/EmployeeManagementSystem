# Employee Management System

## Project Description
The Employee Management System is a Spring Boot application designed to efficiently manage employee data within an organization. It provides a set of RESTful APIs to perform CRUD operations on employee records, as well as additional functionalities such as retrieving the nth level manager of an employee and fetching employees with pagination and sorting options.

## Setup
1. **Java and Maven:** Ensure you have Java JDK (version 8 or later) and Apache Maven installed on your machine.
2. **Database:** Install MongoDB and make sure it's running on the default port (27017).
3. **Clone Repository:** Clone this repository to your local machine.

## Running the Application
1. **Navigate to Project Directory:** Open a terminal/command prompt and navigate to the root directory of the project.
2. **Run Application:** Run the following command to start the Spring Boot application:
***mvn spring-boot:run***
3. **Access Application:** Once the application is running, you can access it at [http://localhost:8080](http://localhost:8080).

## API Documentation
- **Add Employee:** POST /employees
- **Request Body JSON Structure:**
 ```json
 {
     "employeeName": "John Doe",
     "phoneNumber": "1234567890",
     "email": "john.doe@example.com",
     "reportsTo": "managerId",
     "profileImage": "https://example.com/profile.jpg"
 }
 ```

- **Get All Employees:** GET /employees

- **Get Employee by ID:** GET /employees/{id}

- **Delete Employee by ID:** DELETE /employees/{id}

- **Update Employee by ID:** PUT /employees/{id}
- **Request Body JSON Structure:** Same as Add Employee

- **Get nth Level Manager of an Employee:** GET /employees/{id}/manager/{level}

- **Get Employees with Pagination and Sorting:** GET /employees?page={page}&size={size}&sortBy={sortBy}
