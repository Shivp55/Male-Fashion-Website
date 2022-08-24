package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AdminDao;
import Model.Admin;
import connection.DBConnection;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("Login")) {
		Admin a=new Admin();
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		Admin a1=AdminDao.login(a);
		if(a1==null) {
		request.setAttribute("data", "email or password incorrect");
		request.getRequestDispatcher("admin-login.jsp").forward(request, response);
		
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("data", a1);
			request.getRequestDispatcher("admin-index.jsp").forward(request, response);
			}
			
		}
	}

}
