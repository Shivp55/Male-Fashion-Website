package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import Model.Contact;
public class ContactDao {

	public static void insertContactDetails(Contact c) {
		try {
			Connection conn=DBConnection.createConnection();
			String sql="insert into contact(time,name,contact,email,message) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, c.getTime());
			pst.setString(2, c.getName());
			pst.setString(3, c.getContact());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getMessage());
			pst.executeUpdate();
			System.out.println("COntacted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Contact> getAllMessages(){
		List<Contact> list=new ArrayList();
		try {
			Connection conn=DBConnection.createConnection();
			String sql="select * from contact";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Contact c=new Contact();
				c.setTime(rs.getString("time"));
				c.setName(rs.getString("name"));
				c.setMessage(rs.getString("message"));
				list.add(c);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			
		}
		return list;
	}
	
	
}
