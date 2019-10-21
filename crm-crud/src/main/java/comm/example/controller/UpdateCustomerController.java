package comm.example.controller;

import java.io.IOException;

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
 * Servlet implementation class UpdateCustomerController
 */
@WebServlet("/update.do")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO dao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new CustomerDAOImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomerController() {
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
		Customer c = dao.getCustomerById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("tempCustomer", c);
		RequestDispatcher view = request.getRequestDispatcher("update-form.jsp");
		view.forward(request, response);
	}

}
