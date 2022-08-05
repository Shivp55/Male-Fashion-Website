package Controller;
import Model.Customer;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CustomerDao;
import connection.DBConnection;


/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			Customer c=new Customer();
			c.setName(request.getParameter("name"));
			c.setContact(request.getParameter("contact"));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			CustomerDao.insertUser(c);
			request.setAttribute("msg", "Data inserted Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("customer-login.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("login")) {
			Customer c=new Customer();
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			Customer c1=CustomerDao.login(c);
			if(c1==null) {
			request.setAttribute("data", "email or password incorrect");
			request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			
			}
			else {
				HttpSession session=request.getSession();
				session.setAttribute("data",c1);
				request.getRequestDispatcher("customer-index.jsp").forward(request, response);
				}
				
			}	
			else if(action.equalsIgnoreCase("update")) {
			Customer c=new Customer();
			c.setName(request.getParameter("name"));
			c.setContact(request.getParameter("contact"));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			CustomerDao.updateCustomer(c);
			response.sendRedirect("customer-index.jsp");
			
		}
	}

}
