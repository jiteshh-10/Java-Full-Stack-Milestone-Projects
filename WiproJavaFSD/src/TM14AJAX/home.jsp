<!DOCTYPE html>
<html>
<head><title>Home</title></head>
<body>
    <% if (session.getAttribute("userEmail") == null) response.sendRedirect("index.jsp"); %>
    <h2>Welcome, ${userEmail}!</h2>
</body>
</html>