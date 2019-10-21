<%@page import="java.util.List"%>
<%@page import="comm.example.model.Customer"%>
<%@page import="comm.example.dao.*"%>
<html>
<head>
<title>Update Form</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<%
		List<String> list = (List<String>) request.getAttribute("ERROR");
		if (list != null) {
			for (String str : list) {
				out.println("<font color='red'>" + str + "<br/></font>");
			}
		}
	%>
	<form class="text-center border border-light p-5" action="save.do"
		method="post">
		<p class="h4 mb-4">Update Customer Details</p>
		<input type="hidden" name="id" value="${tempCustomer.id}"> <input
			type="text" class="form-control mb-4"
			value="${tempCustomer.firstName}" name="fName"><br /> <input
			type="text" class="form-control mb-4"
			value="${tempCustomer.lastName}" name="lName"><br />

		<!--Address -->
		<div class="form-group">
			<textarea class="form-control rounded-0"
				id="exampleFormControlTextarea" rows="3"
				value="${tempCustomer.address}" name="address"></textarea>
		</div>
		</select> <input class="btn btn-info mr-2" type="submit"><input
			class="btn btn-info" type="reset">
	</form>
</body>
</html>