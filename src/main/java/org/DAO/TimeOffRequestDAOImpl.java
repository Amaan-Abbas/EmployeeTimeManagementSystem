package org.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.model.TimeOffRequest;
import org.resources.DataBconnection;

public class TimeOffRequestDAOImpl implements TimeOffRequestDAO {
    private final Connection connection;

    public TimeOffRequestDAOImpl() {
        this.connection = DataBconnection.getConnection();
    }

    @Override
    public void addTimeOffRequest(TimeOffRequest request) throws SQLException {
        String query = "INSERT INTO time_off_requests (employee_id, start_date, end_date, reason) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, request.getEmployeeId());
            statement.setDate(2, Date.valueOf(request.getStartDate()));
            statement.setDate(3, Date.valueOf(request.getEndDate()));
            statement.setString(4, request.getReason());
            statement.executeUpdate();
        }
    }

    @Override
    public TimeOffRequest getTimeOffRequestById(int id) throws SQLException {
        String query = "SELECT * FROM time_off_requests WHERE id = ?";
        TimeOffRequest request = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request = new TimeOffRequest(resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getDate("end_date").toLocalDate(),
                        resultSet.getString("reason"));
            }
        }
        return request;
    }

    @Override
    public List<TimeOffRequest> getAllTimeOffRequests() throws SQLException {
        String query = "SELECT * FROM time_off_requests";
        List<TimeOffRequest> requests = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                TimeOffRequest request = new TimeOffRequest(resultSet.getInt("id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getDate("end_date").toLocalDate(),
                        resultSet.getString("reason"));
                requests.add(request);
            }
        }
        return requests;
    }

    @Override
    public void updateTimeOffRequest(TimeOffRequest request) throws SQLException {
        String query = "UPDATE time_off_requests SET start_date = ?, end_date = ?, reason = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, Date.valueOf(request.getStartDate()));
            statement.setDate(2, Date.valueOf(request.getEndDate()));
            statement.setString(3, request.getReason());
            statement.setInt(4, request.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteTimeOffRequest(int id) throws SQLException {
        String query = "DELETE FROM time_off_requests WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
