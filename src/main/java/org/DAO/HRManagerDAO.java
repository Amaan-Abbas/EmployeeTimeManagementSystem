package org.DAO;

import java.sql.SQLException;
import java.util.List;

import org.model.HRManager;

public interface HRManagerDAO {
    void addHRManager(HRManager hrManager) throws SQLException;
    HRManager getHRManagerById(int id) throws SQLException;
    List<HRManager> getAllHRManagers() throws SQLException;
    void updateHRManager(HRManager hrManager) throws SQLException;
    void deleteHRManager(int id) throws SQLException;
}
