<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Current Gold Rate</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 30px;
        }

        .container {
            background-color: white;
            padding: 25px;
            max-width: 600px;
            margin: auto;
            border-radius: 8px;
            box-shadow: 0 0 10px #ccc;
        }

        h2 {
            color: #7b2cbf;
            text-align: center;
        }

        .info {
            font-size: 20px;
            margin-top: 30px;
            text-align: center;
        }

        .back {
            margin-top: 30px;
            text-align: center;
        }

        .back a {
            color: #7b2cbf;
            text-decoration: none;
        }

        .back a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Today's Gold Rate</h2>
    <div class="info">
        <p><strong>Date:</strong> ${date}</p>
        <p><strong>Rate per Gram:</strong> ₹${rate}</p>
    </div>
    <div class="back">
        <a href="${pageContext.request.contextPath}/assets">← Back to Assets</a>
    </div>
</div>
</body>
</html>
