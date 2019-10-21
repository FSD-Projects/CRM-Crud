<%@page import="comm.example.dao.CustomerDAOImpl"%>
<%@page import="comm.example.dao.CustomerDAO"%>
<%@page import="comm.example.model.Customer"%>
<%@page import="java.util.List"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<p class="text-center h4 mb-4">Search Result List</p>
	<table class="table">
		<thead class="black white-text">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Address</th>
				<th scope="col">Customer Type</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="searchCustomer" items="${SearchResult}">
				<tr>
					<td>${searchCustomer.firstName}</td>
					<td>${searchCustomer.lastName}</td>
					<td>${searchCustomer.address}</td>
					<td>${searchCustomer.customerType}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>