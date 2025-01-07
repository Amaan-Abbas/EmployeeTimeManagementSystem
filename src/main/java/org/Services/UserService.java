package org.Services;

import org.DAO.UserDAO;
import org.DAO.UserDAOImpl;
import org.model.User;

import java.sql.SQLException;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public void registerUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return userDAO.getUserById(id);
    }
}
