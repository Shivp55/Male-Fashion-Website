package Dao;
import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Admin;


public class AdminDao {
	public static Admin login(Admin a) {
		Admin a1=null;
		Connection conn=DBConnection.createConnection();
		String sql="select * from admin where email=? and password=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,a.getEmail());
			pst.setString(2, a.getPassword());
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				a1=new Admin();
				a1.setId(rs.getInt("id"));
				a1.setName(rs.getString("name"));
				a1.setContact(rs.getString("contact"));
				a1.setEmail(rs.getString("email"));
				a1.setAddress(rs.getString("address"));
				a1.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return a1;	
	}
}
