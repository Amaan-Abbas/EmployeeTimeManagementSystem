package org.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.model.WorkHours;
import org.resources.DataBconnection;

public class WorkHoursDAOImpl implements WorkHoursDAO {
    private final Connection connection;

    public WorkHoursDAOImpl() {
        this.connection = DataBconnection.getConnection();
    }

    @Override
    public void logWorkHours(WorkHours workHours) throws SQLException {
        String query = "INSERT INTO work_hours (employee_id, hours_logged, date) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, workHours.getEmployeeId());
            statement.setDouble(2, workHours.getHoursWorked());
            statement.setDate(3, Date.valueOf(workHours.getDate()));
            statement.executeUpdate();
        }
    }

    @Override
    public WorkHours getWorkHoursById(int id) throws SQLException {
        String query = "SELECT * FROM work_hours WHERE id = ?";
        WorkHours workHours = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                workHours = new WorkHours(resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getDouble("hours_logged"));
            }
        }
        return workHours;
    }

    @Override
    public List<WorkHours> getAllWorkHours() throws SQLException {
        String query = "SELECT * FROM work_hours";
        List<WorkHours> workHoursList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                WorkHours workHours = new WorkHours(resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getDouble("hours_logged"));
                workHoursList.add(workHours);
            }
        }
        return workHoursList;
    }

    @Override
    public void updateWorkHours(WorkHours workHours) throws SQLException {
        String query = "UPDATE work_hours SET hours_logged = ?, date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, workHours.getHoursWorked());
            statement.setDate(2, Date.valueOf(workHours.getDate()));
            statement.setInt(3, workHours.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteWorkHours(int id) throws SQLException {
        String query = "DELETE FROM work_hours WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
