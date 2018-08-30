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
	<h1>Accounts</h1>
	<div align="center">

		<h1>ACCOUNT List</h1>
		<jstl:if test="${accounts != null }">
			<table>
				<tr>
					<th>Account Number</th>
					<th>Account Balance</th>
					<th>Customer ID</th>
				</tr>
				<jstl:forEach items="${accounts}" var="account">
					<tr>
						<td>${account.accountNumber}</td>
						<td>${account.balance}</td>
						<td>${account.customerId}</td>
					</tr>
				</jstl:forEach>
			</table>
		</jstl:if>
		<jstl:if test="${accounts == null}">
			<h2>No Accounts found!</h2>
		</jstl:if>
	</div>
</body>
</html>