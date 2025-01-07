package org.servlet;

import org.Services.EmployeeService;
import org.model.Employee;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        this.employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;

        // Retrieve employee ID from request
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid employee ID");
            return;
        }

        try {
            // Fetch employee details using the service
            Employee employee = employeeService.getEmployeeById(id);

            if (employee != null) {
                // Display the employee details
                response.setContentType("text/html");
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>Update Employee</h2>");
                response.getWriter().println("<form method='POST' action='updateEmployee'>");
                response.getWriter().println("ID: <input type='text' name='id' value='" + employee.getId() + "' readonly><br>");
                response.getWriter().println("Name: <input type='text' name='name' value='" + employee.getName() + "'><br>");
                response.getWriter().println("Position: <input type='text' name='position' value='" + employee.getPosition() + "'><br>");
                response.getWriter().println("<input type='submit' value='Update'>");
                response.getWriter().println("</form>");
                response.getWriter().println("</body></html>");
            } else {
                response.getWriter().println("Employee not found");
            }
        } catch (SQLException e) {
            response.getWriter().println("Error retrieving employee: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String name = request.getParameter("name");
        String position = request.getParameter("position");

        // Validate and parse the employee ID
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid employee ID");
            return;
        }

        if (name != null && !name.trim().isEmpty() && position != null && !position.trim().isEmpty()) {
            try {
                // Create an updated employee object
                Employee employee = new Employee(id, name, position);
                // Update the employee using the service
                employeeService.updateEmployee(employee);
                response.getWriter().println("Employee updated successfully");
            } catch (SQLException e) {
                response.getWriter().println("Error updating employee: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Invalid input: Name and Position cannot be empty");
        }
    }
}
