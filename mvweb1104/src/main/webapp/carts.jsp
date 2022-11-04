<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carts Info</title>
</head>
<body>
<jsp:useBean id="cart" scope="session" class="beans.MyBean" />
 <jsp:setProperty name="cart" property="*" />
<%
	cart.processRequest(request);
%>

<br> You have the following items in your cart:
<ol>
<% 
	String[] items = cart.getItems();
	for (int i=0; i<items.length; i++) {
%>
<li> <% out.print(items[i]); %> 
<%
	}
%>
</ol>

</body>
</html>