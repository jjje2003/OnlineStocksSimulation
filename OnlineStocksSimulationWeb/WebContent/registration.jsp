<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="systemStyle.css">
</head>
<body>
<div align = "center" >
<h2>Register Account</h2>
<form action="${pageContext.request.contextPath}/registerServlet" method="post">
	<table>
		<tr><td>User Name:</td>
		<td><input type="text" name="userName"></td>
		</tr>
		<tr><td>Password:</td>
		<td><input type="text" name="password"></td>
		</tr>
		<tr><td>Confirm Password:</td>
		<td><input type="text" name="password"></td>
		</tr>
		<tr><td></td>
		<td><input type="submit" name="register" value="Register"></td>
		</tr>
		
	</table>	
</form>

</div>
</body>
</html>