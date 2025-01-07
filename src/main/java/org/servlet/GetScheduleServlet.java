package org.servlet;

import org.services.ScheduleService;
import org.model.Schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class GetScheduleServlet extends HttpServlet {
    private ScheduleService scheduleService;

    @Override
    public void init() throws ServletException {
        this.scheduleService = new ScheduleService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int scheduleId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Schedule schedule = scheduleService.getScheduleById(scheduleId);
            if (schedule != null) {
                response.getWriter().println("Schedule for Employee ID " + schedule.getEmployeeId() + ": " + schedule.getShiftHours());
            } else {
                response.getWriter().println("Schedule not found");
            }
        } catch (SQLException e) {
            response.getWriter().println("Error retrieving schedule: " + e.getMessage());
        }
    }
}
