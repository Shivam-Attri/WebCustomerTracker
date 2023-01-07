<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<style>
		.failed {
			color: red;
		}
	</style>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-secondary p-3">

	<div class="card p-2 bg-dark text-white text-center">
	    <div class="card-body"><h1>Customer Relationship Management</h1></div>
	</div>
	
	<div class="container mt-3 card bg-dark text-white text-center" style="width:800px">
	<div class="card-body">
	<h3>Login</h3>
	<form:form action="${pageContext.request.contextPath}/login" method="POST">
		
		<c:if  test="${param.error != null}">
			<i class="failed">You Entered Wrong User-name or Password</i>
		</c:if>
		
		<div class="mb-3 mt-3">
		<label>Username:</label>
	    <input type="text" name="username" />
		</div>

		<div class="mb-3 mt-3">
		<label>Password:</label>
	    <input type="password" name="password" />
		</div>
		
		<input type="submit" value="Login" class="btn btn-secondary"/>	
	</form:form>
	</div>
	</div>
</body>
</html>