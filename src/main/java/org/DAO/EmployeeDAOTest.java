package org.DAO;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.model.Employee;

import java.sql.*;
import java.util.*;

import static org.mockito.Mockito.*;

class EmployeeDAOTest {
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private EmployeeDAOImpl employeeDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        employeeDAO = new EmployeeDAOImpl(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @Test
    void testAddEmployee() throws SQLException {
        Employee employee = new Employee(0, "John Doe", "Developer");

        employeeDAO.addEmployee(employee);

        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testGetEmployeeById() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("John Doe");
        when(mockResultSet.getString("position")).thenReturn("Developer");

        Employee employee = employeeDAO.getEmployeeById(1);

        Assertions.assertNotNull(employee);
        Assertions.assertEquals("John Doe", employee.getName());
        Assertions.assertEquals("Developer", employee.getPosition());
    }

    @Test
    void testGetAllEmployees() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getInt("id")).thenReturn(1, 2);
        when(mockResultSet.getString("name")).thenReturn("John Doe", "Jane Smith");
        when(mockResultSet.getString("position")).thenReturn("Developer", "Manager");

        List<Employee> employees = employeeDAO.getAllEmployees();

        Assertions.assertEquals(2, employees.size());
        Assertions.assertEquals("John Doe", employees.get(0).getName());
    }
}
