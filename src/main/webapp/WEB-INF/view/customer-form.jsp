<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Save Customer</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-secondary p-3">
	<div class="card p-2 bg-dark text-white text-center">
	    <div class="card-body"><h1>Customer Relationship Management</h1></div>
	</div>
	
	
	<div class="container mt-3 card bg-dark text-white text-center" style="width:800px">
	  <div class="card-body">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id" />				
			<div class="mb-3 mt-3">
				<label>First name:</label>
				<form:input path="firstName" /><form:errors path="firstName" id="error"/>
			</div>
			<div class="mb-3 mt-3">
				<label>Last name:</label>
				<form:input path="lastName" /><form:errors path="lastName" id="error"/>
			</div>
			<div class="mb-3 mt-3">
				<label>Email:</label>
				<form:input path="email" /><form:errors path="email" id="error"/>
			</div>
			<input type="submit" value="Save" class="btn btn-secondary" />
		</form:form>
		<div style="clear; both;"></div>
	 </div>
	</div>
	<button class="btn btn-dark text-white" onclick="window.location.href='list';return false;" class="add-button">Back to list</button>
</body>
</html>





