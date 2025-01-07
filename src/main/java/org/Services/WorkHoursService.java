package org.Services;

import java.sql.SQLException;
import java.util.List;

import org.DAO.WorkHoursDAO;
import org.DAO.WorkHoursDAOImpl;
import org.model.WorkHours;

public class WorkHoursService {

    private final WorkHoursDAO workHoursDAO = new WorkHoursDAOImpl();

    // Log work hours
    public void logWorkHours(WorkHours workHours) throws SQLException {
        workHoursDAO.logWorkHours(workHours);
    }

    // Get work hours by ID
    public WorkHours getWorkHoursById(int id) throws SQLException {
        return workHoursDAO.getWorkHoursById(id);
    }

    // Get all work hours
    public List<WorkHours> getAllWorkHours() throws SQLException {
        return workHoursDAO.getAllWorkHours();
    }

    // Update work hours
    public void updateWorkHours(WorkHours workHours) throws SQLException {
        workHoursDAO.updateWorkHours(workHours);
    }

    // Delete work hours
    public void deleteWorkHours(int id) throws SQLException {
        workHoursDAO.deleteWorkHours(id);
    }
}
