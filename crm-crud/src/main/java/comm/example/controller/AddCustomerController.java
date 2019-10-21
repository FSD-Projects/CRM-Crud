package comm.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.model.Customer;

@WebServlet("/add-controller.do")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fName, lName, address, customerType;
	private List<String> errors = null;

	public AddCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		errors = new ArrayList<String>();
		fName = request.getParameter("fName");
		if ((fName == null) || (fName.length() < 5)) {
			errors.add("First name cannot be null or less than 5 chars");
		}
		lName = request.getParameter("lName");
		if ((lName == null) || (lName.length() < 5)) {
			errors.add("Last name cannot be null or less than 5 chars");
		}
		address = request.getParameter("address");
		if ((address.equals(""))) {
			errors.add("Enter address");
		}
		customerType = request.getParameter("custType");
		if (customerType.equals("Unknown")) {
			errors.add("Select a customer type");
		}
		if (!errors.isEmpty()) {
			request.setAttribute("ERROR", errors);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		} else {
			Customer c = new Customer(fName, lName, address, customerType);
			request.setAttribute("SUCCESS", c);
			CustomerDAO dao = new CustomerDAOImpl();
			dao.createCustomer(c);
			RequestDispatcher rd = request.getRequestDispatcher("list-controller.do");
			rd.include(request, response);
		}
	}

}
