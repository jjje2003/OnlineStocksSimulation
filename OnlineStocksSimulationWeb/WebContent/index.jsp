<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="systemStyle.css">
</head>
<body>
<div align = "center" >
<h2>Welcome</h2>
<h2>to</h2>
<h2>Online Stock Simulation system</h2>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
	<table>
		<tr><td>User Name:</td>
		<td><input type="text" name="userName"></td>
		</tr>
		<tr><td>Password:</td>
		<td><input type="text" name="password"></td>
		</tr>		
		<tr><td></td>
		<td><input type="submit" name="login" value="login"><a href="registration.jsp" style="text-decoration: none">
		<span style="font-size:10px; font-weight:bold">Register New User</span></a></td>
		</tr>
		
	</table>	
</form>

</div>
</body>
</html>