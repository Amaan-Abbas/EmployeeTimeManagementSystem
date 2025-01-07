package org.DAO;

import java.sql.SQLException;

import org.model.User;

public interface UserDAO {
    void addUser(User user) throws SQLException;
    User getUserById(int id) throws SQLException;
}
