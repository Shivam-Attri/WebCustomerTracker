<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRM</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wraapper">
		<div id="header">
			<h2>Customer Relationship Management</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<button onclick="window.location.href='showFormForAdd';return false;" class="add-button">Add Customer</button>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last  Name</th>
					<th>Email</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
</body>
</html>