<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
 
<div align = center>
<h2>Confirmation</h2>
<p>${requestScope.confirmationMsg }</p>
<p style="color: #f0f">${requestScope.different }</p>
<form action="${pageContext.request.contextPath}/OptionServlet" method="post">
<table border="1" BGCOLOR = "silver">
<tr><th>Stock ID</th><th>Description</th><th>Price per Share</th><th>Quantity</th><th>Sub Total</th></tr>
	
    <c:forEach items="${requestScope.confirmStocks}" var="item">
	<tr><td>${item.getStockId()}</td>
	<td>${item.getDescription()}</td>	
	<td><fmt:formatNumber type="currency">${item.getCurrentPrice()}</fmt:formatNumber></td>
	<td>${item.getQuantity()}</td>
	<td><fmt:formatNumber type="currency">${item.getCurrentPrice()*item.getQuantity()}</fmt:formatNumber></td>
	</tr>
	<c:set var="total" value="${total + item.getCurrentPrice()*item.getQuantity()}" />
</c:forEach>

<tr><td></td><td>TOTAL </td><td></td><td></td>
	<td><fmt:formatNumber type="currency">${total}</fmt:formatNumber></td>
</tr>
</table>
<br>
<input type="submit" name="option" value="Market List">  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="My Account"/>  &nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="option" value="Logout"/>
</form>
</div>
</body>
</html>