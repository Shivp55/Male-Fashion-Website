package Dao;
import java.util.ArrayList;
import java.util.List;
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
				s1.setAddress(rs.getString("address"));
				s1.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;	
	}
	public static void updateSeller(Seller s) {
		try {
			Connection conn=DBConnection.createConnection();
			String sql="update seller set name=?,contact=?,address=?,email=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getContact());
			pst.setString(3, s.getAddress());
			pst.setString(4, s.getEmail());
			pst.setInt(5, s.getId());
			pst.executeUpdate();
			System.out.println("data updated");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static boolean checkOldPassword(int id, String op) {
		boolean flag=false;
		try {
			Connection conn=DBConnection.createConnection();
			String sql="select * from seller where id=? and password=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void updatePassword(int id,String np) {
		try {
			Connection conn=DBConnection.createConnection();
			String sql="update seller set password=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("Password Updated");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkSellerEmail(String email) {
		boolean flag=false;
		try {
			Connection conn=DBConnection.createConnection();
			String sql="select * from seller where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				flag=true;
				
			}
		}
			catch(Exception e ) {
				e.printStackTrace();
			}
		return flag;
	}
	public static void setNewSellerPassword(String np,String email) {
		try {
			Connection conn=DBConnection.createConnection();
			String sql="update seller set password=? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2,email);
			pst.executeUpdate();
			System.out.println("New Password Set Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Seller> getAllSeller(){
		List<Seller> list = new ArrayList<Seller>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Seller s = new Seller();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getString("contact"));
				s.setAddress(rs.getString("address"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static int getAllSellers(){
		int i=0;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from seller";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				i=i+1;
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}
}

	

