package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Customer;
import Model.Seller;
import connection.DBConnection;


public class CustomerDao {
	public static void insertUser(Customer c) {
		Connection conn=DBConnection.createConnection();
		String sql="insert into customer(name,contact,address,email,password) values(?,?,?,?,?)";
		try{
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getContact());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getPassword());
			pst.executeUpdate();
			System.out.println("Data Inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	public static Customer login(Customer c) {
		Customer c1=null;
		try {
			Connection conn=DBConnection.createConnection();
			String sql="select * from customer where email=? and password=?";
			
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,c.getEmail());
			pst.setString(2, c.getPassword());
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				c1=new Customer();
				c1.setId(rs.getInt("id"));
				c1.setName(rs.getString("name"));
				c1.setContact(rs.getString("contact"));
				c1.setAddress(rs.getString("address"));
				c1.setEmail(rs.getString("email"));
				c1.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c1;	

	}
	public static void updateCustomer(Customer c) {
		try {
			
			Connection conn=DBConnection.createConnection();
			String sql="update customer set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getContact());
			pst.setString(3,c.getAddress());
			pst.setString(5, c.getEmail());
			pst.setInt(5, c.getId());
			pst.executeUpdate();
			System.out.println("Data Inserted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
