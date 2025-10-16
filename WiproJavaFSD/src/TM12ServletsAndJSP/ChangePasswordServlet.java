package TM12ServletsAndJSP;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.dao.UserDAO;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPass = request.getParameter("newPassword");
        String retypePass = request.getParameter("retypeNewPassword");

        if (!newPass.equals(retypePass)) {
            request.setAttribute("errorMessage", "New passwords do not match.");
            request.getRequestDispatcher("changePassword.html").forward(request, response);
            return;
        }

        if (new UserDAO().updatePassword(request.getParameter("username"), request.getParameter("oldPassword"), newPass)) {
            request.setAttribute("successMessage", "Password changed successfully!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Failed to change password. Check credentials.");
            request.getRequestDispatcher("changePassword.html").forward(request, response);
        }
    }
}