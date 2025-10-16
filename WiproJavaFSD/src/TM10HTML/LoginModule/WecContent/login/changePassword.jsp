<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Change Password</title>
</head>
<body>
    <%
        // Redirect to login if session is not active
        if (session.getAttribute("userid") == null) {
            response.sendRedirect("login.html");
        }
    %>

    <h2>Change Your Password</h2>
    <form action="changePassword" method="post">
        Old Password: <input type="password" name="oldPassword" required><br><br>
        New Password: <input type="password" name="newPassword" required><br><br>
        Confirm Password: <input type="password" name="confirmPassword" required><br><br>
        <input type="submit" value="Update Password">
    </form>

    <p style="color:red;">${errorMessage}</p>
</body>
</html>