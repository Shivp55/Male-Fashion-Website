package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.SellerDao;
import Model.Seller;
import Services.Services;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
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
		if(action.equalsIgnoreCase("register")) {
			Seller s=new Seller();
			s.setName(request.getParameter("name"));
			s.setContact(request.getParameter("contact"));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			SellerDao.insertSeller(s);
			RequestDispatcher rd=request.getRequestDispatcher("seller-login.jsp");
			rd.forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("login")) {
			Seller s=new Seller();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			Seller s1=SellerDao.login(s);
			if(s1==null) {
			request.setAttribute("data", "email or password incorrect");
			request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			
			}
			else {
				HttpSession session=request.getSession();
				session.setAttribute("data",s1);
				request.getRequestDispatcher("seller-index.jsp").forward(request, response);
				}
				
			}
		else if(action.equalsIgnoreCase("update")) {
			Seller s=new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(request.getParameter("contact"));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateSeller(s);
			response.sendRedirect("seller-index.jsp");
		}
		
		else if(action.equalsIgnoreCase("change")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String op=request.getParameter("op");
			String np=request.getParameter("np");
			String cnp=request.getParameter("cnp");
			boolean flag=SellerDao.checkOldPassword(id, op);
			if(flag==true) {
				if(np.equals(cnp)) {
					SellerDao.updatePassword(id, np);
					response.sendRedirect("seller-index.jsp");				}
				else {
					request.setAttribute("msg1","New password and Confirm new Password are not Matched");
					request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);	
				}	
			}
			else {
				request.setAttribute("msg", "old password incorrect");
				request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);	
			}
		}
		
		
		else if(action.equalsIgnoreCase("get otp")) {
			String email=request.getParameter("email");
			boolean flag=SellerDao.checkSellerEmail(email);
			if(flag==true) {
				Services s= new Services();
				Random r=new Random();
				int num=r.nextInt(999999);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "email id not registered" );
				request.getRequestDispatcher("seller-forgot-password.jsp").forward(request, response);		
			}
		}
		
		
		else if(action.equalsIgnoreCase("verify")) {
			String email=request.getParameter("email");
			int otp1=Integer.parseInt(request.getParameter("otp1"));
			int otp2=Integer.parseInt(request.getParameter("otp2"));
			System.out.print(email+otp1+otp2);
			if(otp1==otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("seller-new-password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg3", "Otp not Valid");
				request.getRequestDispatcher("seller-forgot-password.jsp").forward(request, response);	
			}			
		}
		
		
		else if(action.equalsIgnoreCase("new password")) {
			String email=request.getParameter("email");
			String np=request.getParameter("np");
			String cnp=request.getParameter("cnp");
			if(np.equals(cnp)) {
				SellerDao.setNewSellerPassword(np, email);
				request.setAttribute("msg4", "New Password Set Successfully");
				request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg5", "New password and Confirm new Password not matched ");
				request.getRequestDispatcher("seller-forgot-password.jsp").forward(request, response);
				
			}
		}
	}
}


