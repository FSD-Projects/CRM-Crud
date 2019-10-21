<%@page import="comm.example.dao.CustomerDAOImpl"%>
<%@page import="comm.example.dao.CustomerDAO"%>
<%@page import="comm.example.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

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
	<%
		
	%>
	<table class="table">
		<thead class="black white-text">
			<tr>
				<th scope="col">Customer ID</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Address</th>
				<th scope="col">Customer Type</th>
			</tr>
		</thead>
		<tbody>
				<%-- <c:forEach var="customer" items="${list}">
					<td scope="row"><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.fName}" /></td>
					<td><c:out value="${customer.lName}" /></td>
					<td><c:out value="${customer.address}" /></td>
					<td><c:out value="${customer.customerType}" /></td>
				</c:forEach> --%>
				<% 
				CustomerDAO dao = new CustomerDAOImpl();
				List<Customer> list = dao.getAllCustomers();
				for(Customer c: list) { %>
					<tr>
					<td><%=c.getId()%></td>
					<td><%=c.getFName()%></td>
					<td><%=c.getLName()%></td>
					<td><%=c.getAddress()%></td>
					<td><%=c.getCustomerType()%></td>
					</tr>
				<%} %>
		</tbody>
	</table>
</body>
</html>