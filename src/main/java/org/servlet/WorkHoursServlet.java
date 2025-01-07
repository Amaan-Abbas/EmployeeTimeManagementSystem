package org.servlet;

import org.Services.WorkHoursService;
import org.model.WorkHours;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class WorkHoursServlet extends HttpServlet {
    private WorkHoursService workHoursService;

    @Override
    public void init() throws ServletException {
        this.workHoursService = new WorkHoursService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        String workDate = request.getParameter("work_date");
        String hoursWorked = request.getParameter("hours_worked");

        try {
            WorkHours workHours = new WorkHours(0, employeeId, workDate, hoursWorked);
            workHoursService.addWorkHours(workHours);
            response.getWriter().println("Work hours logged successfully");
        } catch (SQLException e) {
            response.getWriter().println("Error logging work hours: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));

        try {
            WorkHours workHours = workHoursService.getWorkHoursByEmployeeId(employeeId);
            response.getWriter().println("Employee ID: " + workHours.getEmployeeId() + ", Work Date: " + workHours.getWorkDate() + ", Hours Worked: " + workHours.getHoursWorked());
        } catch (SQLException e) {
            response.getWriter().println("Error retrieving work hours: " + e.getMessage());
        }
    }
}
