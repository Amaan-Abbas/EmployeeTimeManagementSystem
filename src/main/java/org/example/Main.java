package org.example;
import java.sql.SQLException;

import org.Services.EmployeeService;
import org.model.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        try {
            Employee employee = new Employee(1, "John Doe", "Developer");
            employeeService.addEmployee(employee);
            Employee fetchedEmployee = employeeService.getEmployeeById(1);
            System.out.println(fetchedEmployee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
