package org.servlet;

import org.Services.TimeOffRequestService;
import org.model.TimeOffRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddTimeOffRequestServlet extends HttpServlet {
    private TimeOffRequestService timeOffRequestService;

    @Override
    public void init() throws ServletException {
        this.timeOffRequestService = new TimeOffRequestService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        LocalDate startDate = LocalDate.parse(request.getParameter("start_date"));
        LocalDate endDate = LocalDate.parse(request.getParameter("end_date"));

        try {
            TimeOffRequest timeOffRequest = new TimeOffRequest(0, employeeId, startDate, endDate, null);
            timeOffRequestService.addTimeOffRequest(timeOffRequest);
            response.getWriter().println("Time off request added successfully");
        } catch (SQLException e) {
            response.getWriter().println("Error adding time off request: " + e.getMessage());
        }
    }
}
