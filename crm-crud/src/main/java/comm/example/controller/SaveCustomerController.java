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

/**
 * Servlet implementation class SaveCustomerController
 */
@WebServlet("/save.do")
public class SaveCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO dao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new CustomerDAOImpl();
	}

	private List<String> errors;
	private String fName, lName, address;
	private int id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		errors = new ArrayList<String>();
		id = Integer.parseInt(request.getParameter("id"));
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
		if (!errors.isEmpty()) {
			request.setAttribute("ERROR", errors);
			RequestDispatcher rd = request.getRequestDispatcher("update-form.jsp");
			rd.forward(request, response);
		} else {
			Customer c = dao.getCustomerById(id);
			c.setFirstName(fName);
			c.setLastName(lName);
			c.setAddress(address);
			request.setAttribute("SUCCESS", c);
			dao.updateCustomer(c);
			RequestDispatcher rd = request.getRequestDispatcher("list.do");
			rd.include(request, response);
		}
	}

}
