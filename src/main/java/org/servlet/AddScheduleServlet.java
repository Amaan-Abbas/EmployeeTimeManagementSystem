package org.servlet;

import org.Services.ScheduleService;
import org.model.Schedule;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddScheduleServlet extends HttpServlet {
    private ScheduleService scheduleService;

    @Override
    public void init() throws ServletException {
        this.scheduleService = new ScheduleService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        LocalDate shiftDate = LocalDate.parse(request.getParameter("shift_date"));
        String shiftHours = request.getParameter("shift_hours");

        if (employeeId > 0 && shiftDate != null && shiftHours != null) {
            try {
                Schedule schedule = new Schedule(0, employeeId, shiftDate, shiftHours);
                scheduleService.addSchedule(schedule);
                response.getWriter().println("Schedule added successfully");
            } catch (SQLException e) {
                response.getWriter().println("Error adding schedule: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Invalid input");
        }
    }
}
