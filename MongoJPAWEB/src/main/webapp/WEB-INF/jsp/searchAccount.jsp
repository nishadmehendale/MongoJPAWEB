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
<form onsubmit="get_action(this);">
ENter Acc NO:    <input type="number" name="num"></input>
<input type= "submit">
</form>
</body>
<script type="text/javascript">
    function get_action(form) {
        form.action = 'http://'+document.getElementById("address").value;
    }
</script>
</html>