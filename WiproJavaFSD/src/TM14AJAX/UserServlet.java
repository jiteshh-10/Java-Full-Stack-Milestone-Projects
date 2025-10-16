package TM14AJAX;

// package com.example.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.dao.UserDAO;

public class UserServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();

        if ("checkEmail".equals(action)) {
            String email = request.getParameter("email");
            response.setContentType("text/plain");
            if (email == null || !email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                response.getWriter().write("Invalid email-id");
            } else if (dao.emailExists(email)) {
                response.getWriter().write("Email already exists!");
            }
        } else if ("register".equals(action)) {
            if (dao.registerUser(request.getParameter("email"), request.getParameter("password"), request.getParameter("name"), request.getParameter("dob"))) {
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("errorMessage", "Registration failed.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if ("login".equals(action)) {
            if (dao.validateLogin(request.getParameter("email"), request.getParameter("password"))) {
                request.getSession().setAttribute("userEmail", request.getParameter("email"));
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid Credentials");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
}