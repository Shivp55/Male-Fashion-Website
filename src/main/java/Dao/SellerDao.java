package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import Model.Seller;
import connection.DBConnection;
public class SellerDao {
	public static void insertSeller(Seller s) {
		
		Connection conn=DBConnection.createConnection();
		String sql="insert into seller(name,contact,address,email,password) values(?,?,?,?,?)";
		try {
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setString(1,s.getName());
		pst.setString(2, s.getContact());
		pst.setString(3,s.getAddress());
		pst.setString(4, s.getEmail());
		pst.setString(5,s.getPassword());
		pst.executeUpdate();
		System.out.println("Data inserted");
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Seller login(Seller s) {
		Seller s1=null;
		Connection conn=DBConnection.createConnection();
		String sql="select * from seller where email=? and password=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,s.getEmail());
			pst.setString(2, s.getPassword());
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				s1=new Seller();
				s1.setId(rs.getInt("id"));
				s1.setName(rs.getString("name"));
				s1.setContact(rs.getString("contact"));
				s1.setEmail(rs.getString("email"));
				s1.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;	
	}
	
}
