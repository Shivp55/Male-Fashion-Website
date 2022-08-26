package Controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.CartDao;
import Dao.CheckOutDao;
import Dao.ProductDao;
import Model.Cart;
import Model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
		       


		
		// TODO Auto-generated method stub
		doGet(request, response);
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("add to cart")){
				Cart c = new Cart();
				c.setCusid(Integer.parseInt(request.getParameter("cusid")));
				c.setPid(Integer.parseInt(request.getParameter("pid")));
				c.setSid(Integer.parseInt(request.getParameter("sid")));
				c.setImage(request.getParameter("image"));
				c.setPname(request.getParameter("pname"));
				c.setPprice(Double.parseDouble(request.getParameter("pprice")));
				CartDao.insertCart(c);
				response.sendRedirect("customer-index.jsp");
				
	}
			
			
		
		
		
			
			

	}
}
