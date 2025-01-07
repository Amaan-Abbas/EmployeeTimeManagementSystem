package org.servlet;

import org.Services.UserService;
import org.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserRegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Register User</h2>");
        response.getWriter().println("<form method='POST' action='registerUser'>");
        response.getWriter().println("Username: <input type='text' name='username' required><br>");
        response.getWriter().println("Password: <input type='password' name='password' required><br>");
        response.getWriter().println("Email: <input type='email' name='email' required><br>");
        response.getWriter().println("<input type='submit' value='Register'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            User user = new User(0, username, password, email); // Assume ID is auto-generated
            userService.registerUser(user);
            response.getWriter().println("User registered successfully!");
        } catch (SQLException e) {
            response.getWriter().println("Error registering user: " + e.getMessage());
        }
    }
}
