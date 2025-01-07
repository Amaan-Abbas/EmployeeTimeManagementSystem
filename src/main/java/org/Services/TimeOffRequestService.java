package org.Services;

import java.sql.SQLException;
import java.util.List;

import org.DAO.TimeOffRequestDAO;
import org.DAO.TimeOffRequestDAOImpl;
import org.model.TimeOffRequest;

public class TimeOffRequestService {

    private final TimeOffRequestDAO timeOffRequestDAO = new TimeOffRequestDAOImpl();

    // Add time-off request
    public void addTimeOffRequest(TimeOffRequest request) throws SQLException {
        timeOffRequestDAO.addTimeOffRequest(request);
    }

    // Get time-off request by ID
    public TimeOffRequest getTimeOffRequestById(int id) throws SQLException {
        return timeOffRequestDAO.getTimeOffRequestById(id);
    }

    // Get all time-off requests
    public List<TimeOffRequest> getAllTimeOffRequests() throws SQLException {
        return timeOffRequestDAO.getAllTimeOffRequests();
    }

    // Update time-off request
    public void updateTimeOffRequest(TimeOffRequest request) throws SQLException {
        timeOffRequestDAO.updateTimeOffRequest(request);
    }

    // Delete time-off request
    public void deleteTimeOffRequest(int id) throws SQLException {
        timeOffRequestDAO.deleteTimeOffRequest(id);
    }
}
