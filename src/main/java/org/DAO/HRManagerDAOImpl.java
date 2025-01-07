package org.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.model.HRManager;
import org.resources.DataBconnection;

public class HRManagerDAOImpl implements HRManagerDAO {
    private final Connection connection;

    public HRManagerDAOImpl() {
        this.connection = DataBconnection.getConnection();
    }

    @Override
    public void addHRManager(HRManager hrManager) throws SQLException {
        String query = "INSERT INTO hr_managers (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hrManager.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public HRManager getHRManagerById(int id) throws SQLException {
        String query = "SELECT * FROM hr_managers WHERE id = ?";
        HRManager hrManager = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hrManager = new HRManager(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }
        return hrManager;
    }

    @Override
    public List<HRManager> getAllHRManagers() throws SQLException {
        String query = "SELECT * FROM hr_managers";
        List<HRManager> hrManagers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                HRManager hrManager = new HRManager(resultSet.getInt("id"), resultSet.getString("name"));
                hrManagers.add(hrManager);
            }
        }
        return hrManagers;
    }

    @Override
    public void updateHRManager(HRManager hrManager) throws SQLException {
        String query = "UPDATE hr_managers SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hrManager.getName());
            statement.setInt(2, hrManager.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteHRManager(int id) throws SQLException {
        String query = "DELETE FROM hr_managers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
