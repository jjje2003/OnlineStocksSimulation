<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary</title>
<link rel="stylesheet" type="text/css" href="systemStyle.css">
</head>
<body>
<div width="500px" align=center>
<h2>Your Account</h2>
<P>User Name: ${requestSession.userName}</P>
<p>Current Cash: ${requestSession.cash}</p>
<table border="1" BGCOLOR = "silver">
<tr><th>Stock ID</th><th>Stock Name</th><th>Quantity</th><th>Buy In Price</th><th>Market Price</th><th>Stock Value</th></tr>
<c:forEach items="${requestScope.onhandStocks}" var="item">
	<tr><td>${item.getStockId() }</td>
		<td>${item.getStockName()}</td>
		<td>${item.getQuantity()}</td>		
		<td><fmt:formatNumber type="currency">${item.getBuyInPrice()}</fmt:formatNumber></td>
		<td><fmt:formatNumber type="currency">${item.getMarketPrice()}</fmt:formatNumber></td>		
		<td><fmt:formatNumber type="currency">${item.getMarketPrice()*item.getQuantity()}</fmt:formatNumber></td>
	</tr>
	<c:set var="total" value="${total + item.getMarketPrice()*item.getQuantity()}" />
</c:forEach>

<tr><td></td><td>TOTAL Value </td><td></td><td></td><td></td>
	<td><fmt:formatNumber type="currency">${total}</fmt:formatNumber></td>
</tr>
</table>
<p>Account Balance: <fmt:formatNumber type="currency">${total + requestSession.cash}</fmt:formatNumber></p>
<br />
<form action="${pageContext.request.contextPath}/OptionServlet" method="post">
<input type="submit" name="option" value="Market List"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Buy">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Sell"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Logout">
</form>

</body>
</html>