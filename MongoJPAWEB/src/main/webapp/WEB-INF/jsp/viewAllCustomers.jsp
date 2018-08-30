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
<h1>Customers</h1>
<div align="center">

<h1>CUSTOMER List</h1>
<jstl:if test="${customers != null }">
<table>
<tr><th>Customer ID</th><th>Name</th></tr>
<jstl:forEach items="${customers}" var="customer">
    <tr><td>${customer.customerId}</td><td>${customer.name}</td></tr>
</jstl:forEach>
</table>
</jstl:if>
<jstl:if test="${customers == null}">
<h2>No customers found!</h2>
</jstl:if>
</div>

</body>
</html>