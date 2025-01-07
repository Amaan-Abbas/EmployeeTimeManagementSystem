package org.servlet;

import java.io.IOException;
import java.sql.SQLException;

import org.Services.EmployeeService;

public class DeleteEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        this.employeeService = new EmployeeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            employeeService.deleteEmployee(id);
            response.getWriter().println("Employee deleted successfully");
        } catch (SQLException e) {
            response.getWriter().println("Error deleting employee: " + e.getMessage());
        }
    }
}
