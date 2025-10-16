package TM10HTML.LoginModule.servlet;

// In package: com.example.servlet
package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import TM10HTML.LoginModule.dao.UserDAO;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("username");
        String pass = request.getParameter("password");
        UserDAO userDAO = new UserDAO();

        if (userDAO.validateUser(userid, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("userid", userid);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}