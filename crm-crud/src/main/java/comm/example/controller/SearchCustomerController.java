package comm.example.controller;

import java.io.IOException;
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
 * Servlet implementation class SearchCustomerController
 */
@WebServlet("/search.do")
public class SearchCustomerController extends HttpServlet {
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
	public SearchCustomerController() {
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

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Customer> list = dao.searchCustomer(request.getParameter("searchString"));
		request.setAttribute("SearchResult", list);
		RequestDispatcher view = request.getRequestDispatcher("search-list.jsp");
		view.forward(request, response);
	}

}
