package org.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.model.Schedule;
import org.resources.DataBconnection;

public class ScheduleDAOImpl implements ScheduleDAO {
    private final Connection connection;

    public ScheduleDAOImpl() {
        this.connection = DataBconnection.getConnection();
    }

    @Override
    public void addSchedule(Schedule schedule) throws SQLException {
        String query = "INSERT INTO schedules (employee_id, shift_date, shift_hours) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, schedule.getEmployeeId());
            statement.setDate(2, Date.valueOf(schedule.getShiftDate()));
            statement.setString(3, schedule.getShiftHours());
            statement.executeUpdate();
        }
    }

    @Override
    public Schedule getScheduleById(int id) throws SQLException {
        String query = "SELECT * FROM schedules WHERE id = ?";
        Schedule schedule = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                schedule = new Schedule(resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("shift_date").toLocalDate(),
                        resultSet.getString("shift_hours"));
            }
        }
        return schedule;
    }

    @Override
    public List<Schedule> getAllSchedules() throws SQLException {
        String query = "SELECT * FROM schedules";
        List<Schedule> schedules = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Schedule schedule = new Schedule(resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("shift_date").toLocalDate(),
                        resultSet.getString("shift_hours"));
                schedules.add(schedule);
            }
        }
        return schedules;
    }

    @Override
    public void updateSchedule(Schedule schedule) throws SQLException {
        String query = "UPDATE schedules SET shift_date = ?, shift_hours = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, Date.valueOf(schedule.getShiftDate()));
            statement.setString(2, schedule.getShiftHours());
            statement.setInt(3, schedule.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteSchedule(int id) throws SQLException {
        String query = "DELETE FROM schedules WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
