<%-- <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Gold Assets</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style_expense.css' />">

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
}

.container {
	width: 800px;
	margin: auto;
	background-color: #fff;
	border-radius: 8px;
	padding: 25px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

h2, h3 {
	text-align: center;
	color: #5a189a;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 15px;
}

th, td {
	padding: 10px;
	border: 1px solid #ccc;
}

label {
	display: block;
	margin: 10px 0 5px;
	font-weight: bold;
}

input, button {
	padding: 8px;
	width: 100%;
	margin-bottom: 10px;
	border-radius: 4px;
	border: 1px solid #ddd;
}

button {
	background-color: #7b2cbf;
	color: white;
	cursor: pointer;
}

button:hover {
	background-color: #5a189a;
}

.summary-box {
	margin-top: 20px;
	padding: 15px;
	background-color: #eee;
	border-radius: 8px;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Gold Asset Tracker</h2>

		<h2>Welcome, ${name}!</h2>

		<form action="${pageContext.request.contextPath}/assets/add"
			method="post">
			<label>Gold (grams):</label> <input type="number" name="grams"
				step="0.01" required> <label>Purchase Price per Gram
				(₹):</label> <input type="number" name="purchasePricePerGram" step="0.01"
				required> <label>Purchase Date:</label> <input type="date"
				name="purchaseDate" required>

			<button type="submit">Add Asset</button>
		</form>

		<div class="summary-box">
			<h3>Summary</h3>
			<p>
				<strong>Total Holdings:</strong> ${totalGrams} grams
			</p>
			<p>
				<strong>Total Investment:</strong> ₹${totalInvestment}
			</p>
			<p>
				<strong>Current Gold Rate:</strong> ₹${currentGoldRate} per gram
			</p>
			<p>
				<strong>Current Value:</strong> ₹${currentValue}
			</p>
			<p>
				<strong>Profit / Loss:</strong> ₹${profitOrLoss} (${status})
			</p>
		</div>
		<table id="assetTable">
			<tr>
				<th>Grams</th>
				<th>Purchase Price (₹/g)</th>
				<th>Purchase Date</th>
				<th>Total (₹)</th>
				<th>Action</th>
			</tr>
			<c:forEach var="asset" items="${assets}">
				<tr id="row-${asset.id}">
					<td>${asset.grams}</td>
					<td>${asset.purchasePricePerGram}</td>
					<td>${asset.purchaseDate}</td>
					<td>${asset.totalAmount}</td>
					<td>
						<form
							action="${pageContext.request.contextPath}/assets/delete/${asset.id}"
							method="post">
							<button type="submit">Delete</button>
						</form>
					</td>

				</tr>
			</c:forEach>
		</table>

		<br> <a href="${pageContext.request.contextPath}/expenses"
			style="color: #7b2cbf;">← Back to Expenses</a>
	</div>

</body>
</html>
 --%>
 
 
 
 
 
 
 
 
 
 
 
 
 <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Gold Assets</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/style_expense.css' />">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        .container {
            width: 800px;
            margin: auto;
            background-color: #fff;
            border-radius: 8px;
            padding: 25px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        h2, h3 {
            text-align: center;
            color: #5a189a;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
        }

        input, button {
            padding: 8px;
            width: 100%;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }

        button {
            background-color: #7b2cbf;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #5a189a;
        }

        .summary-box {
            margin-top: 20px;
            padding: 15px;
            background-color: #eee;
            border-radius: 8px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Gold Asset Tracker</h2>

    <h2>Welcome, ${name}!</h2>

    <form action="${pageContext.request.contextPath}/assets/add" method="post">
        <label>Gold (grams):</label>
        <input type="number" name="grams" step="0.01" required>

        <label>Purchase Price per Gram (₹):</label>
        <input type="number" name="purchasePricePerGram" step="0.01" required>

        <label>Purchase Date:</label>
        <input type="date" name="purchaseDate" required>

        <button type="submit">Add Asset</button>
    </form>

    <div class="summary-box">
        <h3>Summary</h3>
        <p><strong>Total Holdings:</strong> ${totalGrams} grams</p>
        <p><strong>Total Investment:</strong> ₹${totalInvestment}</p>
        <p><strong>Current Gold Rate:</strong> ₹${currentRate} per gram</p>
    	<p><strong>As on: </strong><fmt:formatDate value="${rateDate}" pattern="dd-MM-yyyy"/></p>
        <p><strong>Current Value:</strong> ₹${currentValue}</p>
        <p>
            <strong>${status}:</strong>
            <c:choose>
                <c:when test="${status == 'Profit'}">
                    <span style="color: green;">+ ₹${profitOrLoss}</span>
                </c:when>
                <c:otherwise>
                    <span style="color: red;">- ₹${profitOrLoss}</span>
                </c:otherwise>
            </c:choose>
        </p>
    </div>

    <table id="assetTable">
        <tr>
            <th>Grams</th>
            <th>Purchase Price (₹/g)</th>
            <th>Purchase Date</th>
            <th>Total (₹)</th>
            <th>Action</th>
        </tr>
        <c:forEach var="asset" items="${assets}">
            <tr id="row-${asset.id}">
                <td>${asset.grams}</td>
                <td>${asset.purchasePricePerGram}</td>
                <td>${asset.purchaseDate}</td>
                <td>${asset.totalAmount}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/assets/delete/${asset.id}" method="post">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/expenses" style="color: #7b2cbf;">← Back to Expenses</a>
</div>

</body>
</html>
 