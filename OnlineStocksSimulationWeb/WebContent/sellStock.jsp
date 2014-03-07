<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell Stock</title>
<link rel="stylesheet" type="text/css" href="systemStyle.css" />
</head>
<body>
<div align = center>
<h2>Sell Stocks</h2>
<p style="color: #f00">${requestScope.errorMsg}</p>
<p>${requestScope.msg}</p>
<form action="${pageContext.request.contextPath}/SellStockServlet" method="post">

<table border="1" BGCOLOR = "silver">
<tr><th>Stock ID</th><th>Description</th><th>Market Price</th><th>Quantity</th><th>Sell Quantity</th></tr>
<c:forEach items="${requestScope.onhandStocks}" var="item">
	<tr><td>${item.getStockId() }</td>
		<td>${item.getDescription()}</td>		
		<td><fmt:formatNumber type="currency">${item.getMarketPrice()}</fmt:formatNumber></td>
		<td>${item.getQuantity()}</td>
		<td><select name="${item.getStockId()}" style="width:100%">			
			<c:forEach var="num" begin="0" end="${item.getQuantity()}" step="1">
				<option value="${num }">${num }</option>
			</c:forEach>			
		</select></td>
	</tr>	
</c:forEach>
</table>
<br />
<input type="submit" name="option" value="Sell Now" ${requestScope.disable }>  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Cancel">
</form>

</body>
</html>