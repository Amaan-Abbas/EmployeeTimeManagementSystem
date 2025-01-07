package org.DAO;

import java.sql.SQLException;
import java.util.List;

import org.model.WorkHours;

public interface WorkHoursDAO {
    void logWorkHours(WorkHours workHours) throws SQLException;
    WorkHours getWorkHoursById(int id) throws SQLException;
    List<WorkHours> getAllWorkHours() throws SQLException;
    void updateWorkHours(WorkHours workHours) throws SQLException;
    void deleteWorkHours(int id) throws SQLException;
}
