<!DOCTYPE html>
<html>
<head>
<title>Library Portal</title>
<style>.error { color: red; } #registerForm { display: none; }</style>
<script>
    function toggleForms() {
        document.getElementById('loginForm').style.display = 'none';
        document.getElementById('registerForm').style.display = 'block';
    }
    function checkEmail() {
        var email = document.getElementById('email').value;
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'user?action=checkEmail&email=' + encodeURIComponent(email), true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                document.getElementById('emailError').innerHTML = xhr.responseText;
            }
        };
        xhr.send();
    }
</script>
</head>
<body>
    <p class="error">${errorMessage}</p>

    <div id="loginForm">
        <h2>Login</h2>
        <form action="user" method="post">
            <input type="hidden" name="action" value="login">
            Email: <input type="text" name="email" required><br><br>
            Password: <input type="password" name="password" required><br><br>
            <input type="submit" value="Login">
        </form>
        <a href="#" onclick="toggleForms()">Register here</a>
    </div>

    <div id="registerForm">
        <h2>Register</h2>
        <form action="user" method="post">
            <input type="hidden" name="action" value="register">
            Name: <input type="text" name="name" required><br><br>
            Email: <input type="text" id="email" name="email" onblur="checkEmail()" required>
                   <span id="emailError" class="error"></span><br><br>
            Password: <input type="password" name="password" required><br><br>
            Date of Birth: <input type="date" name="dob" required><br><br>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>