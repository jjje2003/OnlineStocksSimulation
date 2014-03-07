<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Stocks</title>
<link rel="stylesheet" type="text/css" href="systemStyle.css">
</head>
<body> 
<div align = center>
<h2>Buy Stocks</h2>
<p>Please enter the quantity of each stock item you want to buy, and then click Buy Now.</p>
<form action="${pageContext.request.contextPath}/BuyStockServlet" method="post">
<table border="1" BGCOLOR = "silver">
<tr><th>Stock ID</th><th>Description</th><th>Price per Share</th><th>Quantity Available</th></tr>	
<c:forEach items="${requestScope.marketStocks}" var="item">
	<tr><td>${item.getStockid() }</td>
		<td>${item.getStockname()}</td>		
		<td id="${item.getStockid()}"><fmt:formatNumber type="currency">${item.getCurrentprice()}</fmt:formatNumber></td>
		<td><select id="${item.getStockid()}" style="width:100%">			
			<c:forEach var="num" begin="0" end="${item.getQuantityperslot()}" step="1">
				<option value="${num }">${num }</option>
			</c:forEach>			
		</select></td>		
	</tr>	
</c:forEach>

</table>
<br>
<input type="submit" name="option" value="Buy Now">  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Cancel">
</form>
</div>
</body>
</html>