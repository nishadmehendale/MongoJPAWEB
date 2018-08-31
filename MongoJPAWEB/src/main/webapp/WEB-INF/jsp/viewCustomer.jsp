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
	<jstl:if test="${customer != null}">
		<h1>Customer</h1>
		<table>
			<tr>
				<th>CUSTOMER ID</th>
				<th>CUSTOMER NAME</th>
			</tr>
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.name}</td>
			</tr>
		</table>
		
		<h3 align="center"><a href=${link}>Click here to viewAll Customers</a></h3>
	</jstl:if>
	<jstl:if test="${customer == null}">
		<h2>No Customer found!</h2>
	</jstl:if>
</body>
</html>