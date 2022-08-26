package Controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CheckOutDao;
import Model.Cart;
import Model.CheckOut;
import connection.DBConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * Servlet implementation class CheckOutController
 */
@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutController() {
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
	 * 
	 */
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c1 = Calendar.getInstance();
        c1.setTime(currentDate);

        // manipulate date
       
        c1.add(Calendar.DATE, 3); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        
        // convert calendar to date
       

		String action=request.getParameter("action");
		 
				if(action.equalsIgnoreCase("Place Order")) {
					CheckOut c=new CheckOut();
					Cart ca=new Cart();
					int id=Integer.parseInt(request.getParameter("cusid"));
					c.setFname(request.getParameter("fname"));
					c.setLname(request.getParameter("lname"));
					String fname=request.getParameter("fname");
					//System.out.print(fname+id);
					c.setCusid(Integer.parseInt(request.getParameter("cusid")));
					c.setContact(request.getParameter("contact"));
					c.setTotal(Double.parseDouble(request.getParameter("total")));
					c.setEmail(request.getParameter("email"));
					c.setCountry(request.getParameter("country"));
					c.setState(request.getParameter("state"));
					c.setCity(request.getParameter("city"));
					c.setPincode(Integer.parseInt(request.getParameter("pincode")));
					c.setStaddr(request.getParameter("staddr"));
					 String deliverydate = c1.getTime().toString();
					c.setApmt(request.getParameter("apmt"));
					c.setNotes(request.getParameter("notes"));
					//System.out.print(deliverydate);
					CheckOutDao.checkOut(id, deliverydate, c);
					CheckOutDao.insertIntoDelivery(ca, deliverydate);
					CheckOutDao.deleteFromCart(id);          
					request.getRequestDispatcher("customer-index.jsp").forward(request, response);
					
			
			
			
			
		}
				
	}

}
