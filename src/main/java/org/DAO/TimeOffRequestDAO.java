package org.DAO;

import java.sql.SQLException;
import java.util.List;

import org.model.TimeOffRequest;

public interface TimeOffRequestDAO {
    void addTimeOffRequest(TimeOffRequest request) throws SQLException;
    TimeOffRequest getTimeOffRequestById(int id) throws SQLException;
    List<TimeOffRequest> getAllTimeOffRequests() throws SQLException;
    void updateTimeOffRequest(TimeOffRequest request) throws SQLException;
    void deleteTimeOffRequest(int id) throws SQLException;
}
