package org.servlet;

import org.Services.TimeOffRequestService;
import org.model.TimeOffRequest;

import java.io.IOException;
import java.sql.SQLException;

public class GetTimeOffRequestServlet extends HttpServlet {
    private TimeOffRequestService timeOffRequestService;

    @Override
    public void init() throws ServletException {
        this.timeOffRequestService = new TimeOffRequestService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("id"));
        
        try {
            TimeOffRequest timeOffRequest = timeOffRequestService.getTimeOffRequestById(requestId);
            if (timeOffRequest != null) {
                response.getWriter().println("Time off request for Employee ID " + timeOffRequest.getEmployeeId() + ": From " + timeOffRequest.getStartDate() + " to " + timeOffRequest.getEndDate());
            } else {
                response.getWriter().println("Time off request not found");
            }
        } catch (SQLException e) {
            response.getWriter().println("Error retrieving time off request: " + e.getMessage());
        }
    }
}

