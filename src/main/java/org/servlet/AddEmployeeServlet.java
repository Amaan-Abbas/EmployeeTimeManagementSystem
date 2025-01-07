package org.servlet;

import org.Services.EmployeeService;
import org.model.Employee;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

public class AddEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        this.employeeService = new EmployeeService();
    }

      // Handle GET request (retrieve employee details)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("id");

        if (employeeId != null) {
            try {
                int id = Integer.parseInt(employeeId);
                Employee employee = employeeService.getEmployeeById(id);
                if (employee != null) {
                    response.getWriter().println("Employee Details: " + employee.getName() + ", " + employee.getPosition());
                } else {
                    response.getWriter().println("Employee not found.");
                }
            } catch (SQLException e) {
                response.getWriter().println("Error fetching employee: " + e.getMessage());
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid employee ID format.");
            }
        } else {
            response.getWriter().println("No employee ID provided.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String position = request.getParameter("position");

        if (name != null && position != null) {
            try {
                Employee employee = new Employee(0, name, position);  // Assume id will be auto-generated
                employeeService.addEmployee(employee);
                response.getWriter().println("Employee added successfully");
            } catch (SQLException e) {
                response.getWriter().println("Error adding employee: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Invalid input");
        }
    }
}
