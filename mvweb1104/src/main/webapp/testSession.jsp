<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	session.setAttribute("userName","John")
	<br>
	<%
	     session.setAttribute("userName", "John");
	%>
	session.setAttribute("userName","Mary")
	<br>
	<%
	     session.setAttribute("userName", "Mary");
	%>
	
	目前有<%=application.getAttribute("users")%>個用戶。
	<br> after session.invalidate()
	<br>
	<%
	    session.invalidate();
	%>
	目前有<%=application.getAttribute("users")%>個用戶。

</body>
</html>