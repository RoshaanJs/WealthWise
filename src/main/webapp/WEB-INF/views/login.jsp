<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles_index.css">
</head>
<body>

    <div class="container">
        <h2>User Login</h2>

        <!-- Login Form -->
        <form action="loginUser" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Login</button>
        </form>
		<br>
        <!-- Register Form (Moved Outside Login Form) -->
        <form action="register" method="get">
            <button type="submit" class="register-btn">Register</button>
        </form>

        <p class="error">${error}</p>
        <p class="success">${message}</p>
    </div>

</body>
</html>
