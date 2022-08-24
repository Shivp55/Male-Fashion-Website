<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<script type="text/javascript">
		
		expiration = new Date;
		expiration.setMonth(expiration.getMonth()+6)
		counter = eval(cookieVal("total_visited"))
		counter++
		document.cookie = "total_visited="+counter+";expires=" + expiration.toGMTString()
		 
		 
		function cookieVal(cookieName) {
			thisCookie = document.cookie.split("; ")
			for (i=0; i<thisCookie.length; i++){
				if (cookieName == thisCookie[i].split("=")[0]){
					return thisCookie[i].split("=")[1]
				}
			}
			return 0;
		}
		 
		document.getElementById('result').innerHTML = "<center><h3>You visited this page <label style='font-size:40px;' class='text-info'>"+counter+"</label> times.</h3></center>";

		
		
		</script>
		
	</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<a class="navbar-brand">Sourcecodester</a>
		</div>
	</nav>
	<div class="col-md-3"></div>
	<div class="col-md-6 well">
		<h3 class="text-primary">JavaScript - Simple Visitor Page Count</h3>
		<hr style="border-top:1px dotted #ccc;"/>
		<div id="result"></div>
	</div>
<script src="js/script.js"></script>
</body>
</html>
