package org.Services;

import org.DAO.EmployeeDAO;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.model.Employee;

import java.sql.SQLException;
import java.util.*;

import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    @Mock
    private EmployeeDAO mockEmployeeDAO;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(mockEmployeeDAO);
    }

    @Test
    void testAddEmployee() throws SQLException {
        Employee employee = new Employee(0, "John Doe", "Developer");

        employeeService.addEmployee(employee);

        verify(mockEmployeeDAO, times(1)).addEmployee(employee);
    }

    @Test
    void testGetEmployeeById() throws SQLException {
        Employee mockEmployee = new Employee(1, "John Doe", "Developer");
        when(mockEmployeeDAO.getEmployeeById(1)).thenReturn(mockEmployee);

        Employee employee = employeeService.getEmployeeById(1);

        Assertions.assertNotNull(employee);
        Assertions.assertEquals("John Doe", employee.getName());
    }

    @Test
    void testGetAllEmployees() throws SQLException {
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "John Doe", "Developer"),
                new Employee(2, "Jane Smith", "Manager")
        );
        when(mockEmployeeDAO.getAllEmployees()).thenReturn(mockEmployees);

        List<Employee> employees = employeeService.getAllEmployees();

        Assertions.assertEquals(2, employees.size());
        Assertions.assertEquals("John Doe", employees.get(0).getName());
    }
}
