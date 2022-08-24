
<%@ page import="java.sql.*"%>
<%
int qty =Integer.parseInt(request.getParameter("val"));
int id=Integer.parseInt(request.getParameter("val2"));
if (qty==0) {
	out.print("<p>Please enter Email!</p>");
} else {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/malefashion", "root", "");
		PreparedStatement ps = con.prepareStatement("update cart set pprice=pprice*? where cusid=?");
		
		ps.setInt(1, qty);
		ps.setInt(2,id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		out.println("<p>Email Id Already Used</p>");
		}

		con.close();
	} catch (Exception e) {
		out.print(e);
	}
}
%>
