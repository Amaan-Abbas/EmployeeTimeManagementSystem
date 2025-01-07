package org.servlet;

import org.Services.UserService;
import org.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserProfileServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId;
        try {
            userId = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid user ID");
            return;
        }

        try {
            User user = userService.getUserById(userId);
            if (user != null) {
                response.setContentType("text/html");
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>User Profile</h2>");
                response.getWriter().println("ID: " + user.getId() + "<br>");
                response.getWriter().println("Username: " + user.getUsername() + "<br>");
                response.getWriter().println("Email: " + user.getEmail() + "<br>");
                response.getWriter().println("</body></html>");
            } else {
                response.getWriter().println("User not found");
            }
        } catch (SQLException e) {
            response.getWriter().println("Error fetching user: " + e.getMessage());
        }
    }
}
