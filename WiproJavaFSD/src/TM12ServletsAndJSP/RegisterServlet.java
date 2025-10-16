package TM12ServletsAndJSP;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.dao.UserDAO;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (new UserDAO().addUser(request.getParameter("username"), request.getParameter("password"))) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Username may already exist.");
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }
}