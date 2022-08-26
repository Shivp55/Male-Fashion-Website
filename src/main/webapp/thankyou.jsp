<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
    <%@ page import="Model.Cart" %> 
  <%@page import= "Dao.CartDao" %>
  <%@page import="java.sql.*" %>
  <%@ page import="connection.DBConnection" %>
 <%@page import= "java.text.DateFormat" %> 
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
  
    
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
					
	</head>
<body>

<% 
 DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");	

Date currentDate = new Date();
System.out.println(dateFormat.format(currentDate));
int d=currentDate.getDate()+1;
int m=currentDate.getMonth()+1;
int y=currentDate.getYear()-100+2000;
String dte=String.valueOf(y);String.valueOf(m);String.valueOf(d);
System.out.print(dte);
Date cudate = new SimpleDateFormat("dd/mm/yyyy").parse(dte);

out.print(cudate);
 %>
</body>
</html>
