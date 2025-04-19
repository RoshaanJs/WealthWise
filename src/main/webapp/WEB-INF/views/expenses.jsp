<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Expense Tracker</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style_expense.css'/>">
</head>

<body>
    <h2>Welcome, ${name}!</h2>
    <h3>Your Expenses:</h3>

    <!-- Total Expenses Section -->
    <h3>Total Expenses: ₹<span id="totalAmount">${totalAmount}</span></h3>

    <table border="1">
        <tr>
            <th>Description</th>
            <th>Amount</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td>${expense.description}</td>
                <td class="expenseAmount">${expense.amount}</td>
                <td>${expense.category}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/expenses/delete/${expense.id}" method="post">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Add New Expense:</h3>
    <form action="${pageContext.request.contextPath}/expenses/add" method="post" onsubmit="return addExpense(this)">
        <label>Description:</label>
        <input type="text" name="description" required>
        <label>Amount:</label>
        <input type="number" name="amount" step="0.01" required>
        <label>Category:</label>
        <input type="text" name="category" required>
        <button type="submit">Add</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    <br>
	<a href="${pageContext.request.contextPath}/assets" class="asset-button">Go to Asset Tracker</a>
    

    <script>
        function updateTotalAmount() {
            let total = 0;
            document.querySelectorAll(".expenseAmount").forEach(expense => {
                total += parseFloat(expense.innerText) || 0;
            });
            document.getElementById("totalAmount").innerText = total.toFixed(2);
        }

        function addExpense(form) {
            let amount = parseFloat(form.querySelector("input[name='amount']").value);
            if (!isNaN(amount)) {
                let total = parseFloat(document.getElementById("totalAmount").innerText);
                document.getElementById("totalAmount").innerText = (total + amount).toFixed(2);
            }
            return true;
        }
        document.addEventListener("DOMContentLoaded", updateTotalAmount);
    </script>
</body>
</html>
