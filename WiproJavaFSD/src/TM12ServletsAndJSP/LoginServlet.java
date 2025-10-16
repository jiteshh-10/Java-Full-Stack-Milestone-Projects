package TM12ServletsAndJSP;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.dao.UserDAO;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (new UserDAO().validate(request.getParameter("username"), request.getParameter("password"))) {
            request.getSession().setAttribute("username", request.getParameter("username"));
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
