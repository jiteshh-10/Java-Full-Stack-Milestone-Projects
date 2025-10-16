<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <h2>Login Page</h2>
    <p style="color:red;">${errorMessage}</p>
    <p style="color:green;">${successMessage}</p>
    <form action="login" method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="register.html">New User</a> |
    <a href="changePassword.html">Change Password</a>
</body>
</html>