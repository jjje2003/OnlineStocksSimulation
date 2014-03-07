<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Stocks</title>
<link rel="stylesheet" type="text/css" href="systemStyle.css">
</head>
<body>
<div align = center>
<h2>Market Stocks</h2>
<p>Market stocks are available as following:</p>
<table border="1" BGCOLOR = "silver">
<tr><th>Stock ID</th><th>Description</th><th>Price per Share</th><th>Quantity Available</th></tr>
	
<c:forEach items="${requestScope.marketStocks}" var="item">
	<tr><td>${item.getStockid() }</td>
		<td>${item.getStockname() }</td>		
		<td id="${item.getStockid()}"><fmt:formatNumber type="currency">${item.getCurrentprice()}</fmt:formatNumber></td>
		<td>${item.getQuantityperslot()}</td>		
	</tr>	
</c:forEach>

</table>
<br>
<form action="${pageContext.request.contextPath}/OptionServlet" method="post">
<input type="submit" name="option" value="My Account">  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Buy">  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Sell">  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Logout">
</form>
</div>
</body>
</html>