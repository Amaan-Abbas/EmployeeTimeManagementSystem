package org.servlet;

import org.Services.EmployeeService;
import org.model.Employee;
import java.io.IOException;
import java.sql.SQLException;

public class GetEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        this.employeeService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                response.getWriter().println("Employee Name: " + employee.getName());
            } else {
                response.getWriter().println("Employee not found");
            }
        } catch (SQLException e) {
            response.getWriter().println("Error retrieving employee: " + e.getMessage());
        }
    }
}
