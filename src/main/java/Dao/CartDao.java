package Dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import Model.Cart;

public class CartDao {
	public static void insertCart(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into cart(cusid,pid,sid,image,pname,pprice) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getCusid());
			pst.setInt(2, c.getPid());
			pst.setInt(3, c.getSid());
			pst.setString(4, c.getImage());
			pst.setString(5, c.getPname());
			pst.setDouble(6, c.getPprice());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Cart> getAllProductsById(int id){
		List<Cart> list=new ArrayList();
		try {
			Connection conn=DBConnection.createConnection();
			String sql="select * from cart where cusid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Cart c=new Cart();
				c.setPid(rs.getInt("pid"));
				c.setCusid(rs.getInt("cusid"));
				c.setImage(rs.getString("image"));
				c.setPname(rs.getString("pname"));
				c.setPprice(rs.getDouble("pprice"));
				list.add(c);
			}	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list; 
		
	}
}
