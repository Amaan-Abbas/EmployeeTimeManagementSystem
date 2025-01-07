package org.Services;

import java.sql.SQLException;
import java.util.List;

import org.DAO.ScheduleDAO;
import org.DAO.ScheduleDAOImpl;
import org.model.Schedule;

public class ScheduleService {

    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    // Add schedule
    public void addSchedule(Schedule schedule) throws SQLException {
        scheduleDAO.addSchedule(schedule);
    }

    // Get schedule by ID
    public Schedule getScheduleById(int id) throws SQLException {
        return scheduleDAO.getScheduleById(id);
    }

    // Get all schedules
    public List<Schedule> getAllSchedules() throws SQLException {
        return scheduleDAO.getAllSchedules();
    }

    // Update schedule
    public void updateSchedule(Schedule schedule) throws SQLException {
        scheduleDAO.updateSchedule(schedule);
    }

    // Delete schedule
    public void deleteSchedule(int id) throws SQLException {
        scheduleDAO.deleteSchedule(id);
    }
}
