<!DOCTYPE html>
<html>
<head><title>Home</title></head>
<body>
    <% if (session.getAttribute("username") == null) response.sendRedirect("login.jsp"); %>
    <h2>Welcome, ${username}!</h2>
    <p>You have successfully logged in.</p>
</body>
</html>