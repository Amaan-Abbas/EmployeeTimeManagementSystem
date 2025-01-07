package org.DAO;

import java.sql.SQLException;
import java.util.List;

import org.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
}
