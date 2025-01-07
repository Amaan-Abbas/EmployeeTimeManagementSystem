package org.servlet;

import org.services.EmployeeService;
import org.services.ScheduleService;
import org.services.TimeOffRequestService;
import org.model.Employee;
import org.model.HRManager;
import org.model.Schedule;
import org.model.TimeOffRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HRManagerServlet extends HttpServlet {
    private EmployeeService employeeService;
    private ScheduleService scheduleService;
    private TimeOffRequestService timeOffRequestService;

    @Override
    public void init() throws ServletException {
        this.employeeService = new EmployeeService();
        this.scheduleService = new ScheduleService();
        this.timeOffRequestService = new TimeOffRequestService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            List<Schedule> schedules = scheduleService.getAllSchedules();
            List<TimeOffRequest> timeOffRequests = timeOffRequestService.getAllTimeOffRequests();
            
            // Displaying data for HR Manager
            response.getWriter().println("Employees: " + employees.size());
            for (Employee employee : employees) {
                response.getWriter().println("Employee: " + employee.getName() + ", Position: " + employee.getPosition());
            }

            response.getWriter().println("Schedules: " + schedules.size());
            for (Schedule schedule : schedules) {
                response.getWriter().println("Schedule: Employee ID " + schedule.getEmployeeId() + ", Shift: " + schedule.getShiftHours());
            }

            response.getWriter().println("Time Off Requests: " + timeOffRequests.size());
            for (TimeOffRequest timeOffRequest : timeOffRequests) {
                response.getWriter().println("Request: Employee ID " + timeOffRequest.getEmployeeId() + ", Dates: " + timeOffRequest.getStartDate() + " to " + timeOffRequest.getEndDate());
            }
            
        } catch (SQLException e) {
            response.getWriter().println("Error retrieving data: " + e.getMessage());
        }
    }

     // Handle POST request (add or update HR Manager)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        if (name != null && role != null) {
            try {
                HRManager hrManager = new HRManager(0, name, role);
                hrManagerService.addHRManager(hrManager);
                response.getWriter().println("HR Manager added successfully.");
            } catch (SQLException e) {
                response.getWriter().println("Error adding HR Manager: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Invalid input.");
        }
    }
}
