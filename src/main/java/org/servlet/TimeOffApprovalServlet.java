package org.servlet;

import org.Services.TimeOffRequestService;
import org.model.TimeOffRequest;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class TimeOffApprovalServlet extends HttpServlet {
    private TimeOffRequestService timeOffRequestService;

    @Override
    public void init() throws ServletException {
        this.timeOffRequestService = new TimeOffRequestService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId;

        // Parse the request_id parameter from the URL
        try {
            requestId = Integer.parseInt(request.getParameter("request_id"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid request ID");
            return;
        }

        try {
            // Fetch the time-off request from the service
            TimeOffRequest timeOffRequest = timeOffRequestService.getTimeOffRequestById(requestId);

            if (timeOffRequest != null) {
                // Display the time-off request details
                response.setContentType("text/html");
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>Time Off Request Details</h2>");
                response.getWriter().println("<p><strong>Request ID:</strong> " + timeOffRequest.getId() + "</p>");
                response.getWriter().println("<p><strong>Employee ID:</strong> " + timeOffRequest.getEmployeeId() + "</p>");
                response.getWriter().println("<p><strong>Start Date:</strong> " + timeOffRequest.getStartDate() + "</p>");
                response.getWriter().println("<p><strong>End Date:</strong> " + timeOffRequest.getEndDate() + "</p>");
                response.getWriter().println("<p><strong>Status:</strong> " + timeOffRequest.getStatus() + "</p>");
                response.getWriter().println("</body></html>");
            } else {
                response.getWriter().println("Time off request not found");
            }

        } catch (SQLException e) {
            response.getWriter().println("Error retrieving time off request: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId;
        String action;

        // Parse the request_id parameter and action from the request
        try {
            requestId = Integer.parseInt(request.getParameter("request_id"));
            action = request.getParameter("action"); // approve or reject
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid request ID");
            return;
        }

        try {
            // Fetch the time-off request from the service
            TimeOffRequest timeOffRequest = timeOffRequestService.getTimeOffRequestById(requestId);

            if (timeOffRequest != null) {
                if ("approve".equalsIgnoreCase(action)) {
                    timeOffRequest.setStatus("Approved");
                    timeOffRequestService.updateTimeOffRequest(timeOffRequest);
                    response.getWriter().println("Time off request approved");
                } else if ("reject".equalsIgnoreCase(action)) {
                    timeOffRequest.setStatus("Rejected");
                    timeOffRequestService.updateTimeOffRequest(timeOffRequest);
                    response.getWriter().println("Time off request rejected");
                } else {
                    response.getWriter().println("Invalid action");
                }
            } else {
                response.getWriter().println("Time off request not found");
            }

        } catch (SQLException e) {
            response.getWriter().println("Error approving/rejecting time off request: " + e.getMessage());
        }
    }
}
