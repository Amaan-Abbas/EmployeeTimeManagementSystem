package DAO;

import java.util.List;
import java.sql.SQLException;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
}
