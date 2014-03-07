<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<br>
<span class="error">${requestScope.error_msg }</span>
<form action="${pageContext.request.contextPath}/login" method="post">

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