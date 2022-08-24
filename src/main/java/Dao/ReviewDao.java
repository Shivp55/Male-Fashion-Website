package Dao;

import java.sql.Connection;
import java.sql.*;

import connection.DBConnection;
import Model.Review;

public class ReviewDao {

	public static void insertReview(Review r) {
		try {
		Connection conn=DBConnection.createConnection();
		String sql="insert into review (name,email,review) values(?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, r.getName());
		pst.setString(2, r.getEmail());
		pst.setString(3, r.getReview());
		pst.executeUpdate();
		System.out.println("Reviewed Successfully");
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public static int allReviews() {
		int i=0;
		try {
		Connection conn=DBConnection.createConnection();
		String sql="select * from review";
		PreparedStatement pst=conn.prepareStatement(sql);
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
