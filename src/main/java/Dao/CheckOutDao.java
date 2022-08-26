package Dao;
import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Model.Cart;
import Model.CheckOut;
public class CheckOutDao {
	public static void checkOut(int id,String deliverydate,CheckOut c) {
			 	 try {
			 		        
		        Connection conn = DBConnection.createConnection();
					String sql="insert into orders(cusid,fname,lname,contact,email,country,state,city,pincode,street,apartment,notes,total,deliverydate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, id);
					pst.setString(2, c.getFname());
					pst.setString(3, c.getLname());
					pst.setString(4, c.getContact());
					pst.setString(5, c.getEmail());
					pst.setString(6, c.getCountry());
					pst.setString(7, c.getState());
					pst.setString(8, c.getCity());
					pst.setInt(9, c.getPincode());
					pst.setString(10, c.getStaddr());
					pst.setString(11, c.getApmt());
					pst.setString(12, c.getNotes());
					pst.setDouble(13, c.getTotal());
					pst.setString(14, deliverydate);
					pst.executeUpdate();
					System.out.println("data inserted");
					
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static void insertIntoDelivery(Cart ca,String deliverydate) {
		
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into delivery(cusid,pid,pprice,deliverydate) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, ca.getCusid());
			pst.setInt(2, ca.getPid());
			pst.setDouble(3, ca.getPprice());
			pst.setString(4, deliverydate);
			pst.executeUpdate();
			System.out.println("Data added for delivery");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteFromCart(int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="delete from cart where cusid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Data deleted");
		
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	}


