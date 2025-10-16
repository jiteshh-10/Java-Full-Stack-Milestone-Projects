<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <h2>Employee Login</h2>
    <p style="color:red;">${errorMessage}</p>
    <form action="login" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>