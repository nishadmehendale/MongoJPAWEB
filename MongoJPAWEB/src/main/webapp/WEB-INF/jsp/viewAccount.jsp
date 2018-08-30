<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jstl:if test="${account != null}">
	<h1>Account</h1>
	<table>
		<tr>
			<th>Account Number</th>
			<th>Account Balance</th>
			<th>Customer ID</th>
		</tr>
		<tr>
			<td>${account.accountNumber}</td>
			<td>${account.balance}</td>
			<td>${account.customerId}</td>
		</tr>
	</table>
	</jstl:if>
	<jstl:if test="${account == null}">
			<h2>No Account found!</h2>
		</jstl:if>
</body>
</html>