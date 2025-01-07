package org.servlet;

import java.io.IOException;
import java.sql.SQLException;
import org.Services.WorkHoursService;
import org.model.WorkHours;

public class WorkHoursReportServlet extends HttpServlet {
    private WorkHoursService workHoursService;

    @Override
    public void init() throws ServletException {
        this.workHoursService = new WorkHoursService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));

        try {
            String workHoursReport = workHoursService.generateWorkHoursReport(employeeId);
            response.getWriter().println(workHoursReport);
        } catch (Exception e) {
            response.getWriter().println("Error generating work hours report: " + e.getMessage());
        }
    }

     // Handle POST request (log work hours)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        String hoursWorked = request.getParameter("hoursWorked");

        if (employeeId != null && hoursWorked != null) {
            try {
                int id = Integer.parseInt(employeeId);
                double hours = Double.parseDouble(hoursWorked);
                WorkHours workHours = new WorkHours(0, id, hours);
                workHoursService.logWorkHours(workHours);
                response.getWriter().println("Work hours logged successfully.");
            } catch (SQLException e) {
                response.getWriter().println("Error logging work hours: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Invalid input.");
        }
    }
}
