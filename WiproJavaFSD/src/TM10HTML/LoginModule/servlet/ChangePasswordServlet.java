package TM10HTML.LoginModule.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import TM10HTML.LoginModule.dao.UserDAO;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");
        String confirmPass = request.getParameter("confirmPassword");

        if (userid == null) {
            response.sendRedirect("login.html");
            return;
        }

        if (!newPass.equals(confirmPass)) {
            request.setAttribute("errorMessage", "New passwords do not match.");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }

        UserDAO userDAO = new UserDAO();
        if (userDAO.changePassword(userid, oldPass, newPass)) {
            // Password changed successfully, invalidate session and redirect to login
            session.invalidate();
            response.sendRedirect("login.html");
        } else {
            request.setAttribute("errorMessage", "Failed to change password. Check your old password.");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
    }
}
