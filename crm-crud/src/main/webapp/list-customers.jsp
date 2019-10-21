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
	<h3>Customer Relationship Management</h3>
	<a href="add-customer.jsp"><button>Add Customer</button></a>
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
			<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.address}</td>
					<td>${tempCustomer.customerType}</td>
				</tr>
			</c:forEach>
			<%-- <%
				CustomerDAO dao = new CustomerDAOImpl();
				List<Customer> list = dao.getAllCustomers();
				for (Customer c : list) {
			%> --%>
			<%-- <tr>
				<td><%=c.getId()%></td>
				<td><%=c.getFName()%></td>
				<td><%=c.getLName()%></td>
				<td><%=c.getAddress()%></td>
				<td><%=c.getCustomerType()%></td>
			</tr>
			<%
				}
			%> --%>
		</tbody>
	</table>
</body>
</html>