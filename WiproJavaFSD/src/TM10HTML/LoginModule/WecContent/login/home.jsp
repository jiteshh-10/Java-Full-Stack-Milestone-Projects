<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>
<body>
    <%
        // Redirect to login if session is not active
        if (session.getAttribute("userid") == null) {
            response.sendRedirect("login.html");
        }
    %>

    <h1>Welcome to <%= session.getAttribute("userid") %></h1>
    <a href="changePassword.jsp">Change Password</a>
</body>
</html>