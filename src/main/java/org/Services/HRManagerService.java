package org.Services;

import java.sql.SQLException;
import java.util.List;

import org.DAO.HRManagerDAO;
import org.DAO.HRManagerDAOImpl;
import org.model.HRManager;

public class HRManagerService {

    private final HRManagerDAO hrManagerDAO = new HRManagerDAOImpl();

    // Add HR Manager
    public void addHRManager(HRManager hrManager) throws SQLException {
        hrManagerDAO.addHRManager(hrManager);
    }

    // Get HR Manager by ID
    public HRManager getHRManagerById(int id) throws SQLException {
        return hrManagerDAO.getHRManagerById(id);
    }

    // Get all HR Managers
    public List<HRManager> getAllHRManagers() throws SQLException {
        return hrManagerDAO.getAllHRManagers();
    }

    // Update HR Manager
    public void updateHRManager(HRManager hrManager) throws SQLException {
        hrManagerDAO.updateHRManager(hrManager);
    }

    // Delete HR Manager
    public void deleteHRManager(int id) throws SQLException {
        hrManagerDAO.deleteHRManager(id);
    }
}
