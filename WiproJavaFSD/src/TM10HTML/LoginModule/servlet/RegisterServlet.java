package TM10HTML.LoginModule.servlet;

import TM10HTML.LoginModule.Bean.User;
import TM10HTML.LoginModule.dao.UserDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserid(request.getParameter("userid"));
        user.setPassword(request.getParameter("password"));
        user.setDob(Date.valueOf(request.getParameter("dob")));
        user.setGender(request.getParameter("gender"));
        user.setState(request.getParameter("state"));
        user.setContact(request.getParameter("contact"));
        user.setAddress(request.getParameter("address"));

        UserDAO userDAO = new UserDAO();
        if (userDAO.registerUser(user)) {
            response.sendRedirect("login.html");
        } else {
            // Handle registration failure
            request.setAttribute("errorMessage", "Registration failed. User ID might already exist.");
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }
}
