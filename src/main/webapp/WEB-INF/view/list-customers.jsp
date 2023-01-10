<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CRM</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-secondary p-3">
	<div class="card p-2 bg-dark text-white text-center">
	    <div class="card-body"><h1>Customer Relationship Management</h1></div>
	</div>
	<nav class="navbar navbar-expand-sm">
	  <div class="container-fluid row">
	    <ul class="navbar-nav">
	      <li class="nav-item col-sm-9">
	        <div class="nav-link">
	        	<sec:authorize access="hasRole('ADMIN')">
				<button class="btn btn-dark text-white" onclick="window.location.href='showFormForAdd';return false;" class="add-button">Add Customer</button>
	      		</sec:authorize>
	      	</div>
	      </li>
	      <li class="nav-item ">
	       <div class="nav-link">
	        <form action="${pageContext.request.contextPath}/customer/searchCustomers" method="GET">
				<div class="input-group mb-3">
					<input type="text" name="searchText" placeholder="Search Customer" class="form-control">
					<button type="submit" class="btn btn-dark">Search</button>
				</div>
			</form>
		   </div>
	      </li>
	      <li class="nav-item ">
	       <div class="nav-link">
	        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<div>
					<button type="submit" class="btn btn-dark">Logout</button>
				</div>
			</form:form>
		   </div>
	      </li>
	    </ul>
	  </div>
    </nav>
	<div class="container mt-3">
		<div>
			<table class="table table-dark table-striped table-hover">
				<tr>
					<th>First Name</th>
					<th>Last  Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<sec:authorize access="hasRole('ADMIN')">
							<form:form action="${pageContext.request.contextPath}/customer/updateCustomer" method="POST">
								<input type="hidden" value="${tempCustomer.id}" name="customerId">
								<button type="submit" class="btn btn-secondary btn-outline-dark btn-sm">Update</button>
							</form:form>
							<form:form action="${pageContext.request.contextPath}/customer/deleteCustomer" method="POST">
								<input type="hidden" value="${tempCustomer.id}" name="customerId">
								<button type="submit" onclick="if(!(confirm('are you want to delete customer?'))) return false" class="btn btn-secondary btn-outline-dark btn-sm">Delete</button>
							</form:form>
							</sec:authorize>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<button class="btn btn-dark text-white" onclick="window.location.href='list';return false;" class="add-button">Back to list</button>
	
</body>
</html>