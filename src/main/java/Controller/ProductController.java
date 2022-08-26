package Controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.ProductDao;
import Model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024
		* 512)
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("upload product")) {

			String savePath = "C:\\Users\\Omen\\eclipse-workspace\\Male Fashion\\src\\main\\webapp\\uploaded images";
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			Part file1 = request.getPart("image");
			String fileName = extractfilename(file1);
			file1.write(savePath + File.separator + fileName);
			String filePath = savePath + File.separator + fileName;

			String savePath2 = "C:\\Users\\Omen\\eclipse-workspace\\Male Fashion\\src\\main\\webapp\\uploaded images";
			File imgSaveDir = new File(savePath2);
			if (!imgSaveDir.exists()) {
				imgSaveDir.mkdir();
			}
			Product p = new Product();
			p.setSid(Integer.parseInt(request.getParameter("sid")));
			p.setImage(fileName);
			p.setPname(request.getParameter("pname"));
			p.setPprice(Double.parseDouble(request.getParameter("pprice")));
			p.setPcategory(request.getParameter("pcategory"));
			String pcty=request.getParameter("pcategory");
			System.out.print(pcty);
			String s1="newarrivals";
			String s2="Shoes";
			String s3="Watchess";
			String s4="Specss";
			if(pcty.length()==s1.length()) {
				ProductDao.insertIntoNewArrivals(p);
				response.sendRedirect("seller-upload-product.jsp");	
			}
			else if(pcty.length()==s2.length()) {
				ProductDao.insertIntoShoes(p);
				response.sendRedirect("seller-upload-product.jsp");	
		
			}
			else if(pcty.length()==s3.length()) {
				ProductDao.insertIntoWatches(p);
				response.sendRedirect("seller-upload-product.jsp");	
		
			}
			else if (pcty.length()==s4.length()){
				ProductDao.insertIntoSpecs(p);
				response.sendRedirect("seller-upload-product.jsp");	
		
			}
		}
	
		
		else if(action.equalsIgnoreCase("delete4")) {
			Product p=new Product();
			p.setPid(Integer.parseInt((request.getParameter("id2"))));;
			
			ProductDao.deleteProduct(p);
			request.setAttribute("delete", "data deleted");
			response.sendRedirect("seller-manage-product.jsp");	
		}
		else if(action.equalsIgnoreCase("delete1")) {
			Product p=new Product();
			p.setPid(Integer.parseInt((request.getParameter("id2"))));;
			
			ProductDao.deleteShoes(p);
			request.setAttribute("delete", "data deleted");
			response.sendRedirect("seller-manage-product.jsp");	
		}
		else if(action.equalsIgnoreCase("delete2")) {
			Product p=new Product();
			p.setPid(Integer.parseInt((request.getParameter("id2"))));;
			
			ProductDao.deleteSpecs(p);
			request.setAttribute("delete", "data deleted");
			response.sendRedirect("seller-manage-product.jsp");	
		}
		
		else if(action.equalsIgnoreCase("delete3")) {
			Product p=new Product();
			p.setPid(Integer.parseInt((request.getParameter("id2"))));;
			
			ProductDao.deleteWatches(p);
			request.setAttribute("delete", "data deleted");
			response.sendRedirect("seller-manage-product.jsp");	
		}
	}		
}