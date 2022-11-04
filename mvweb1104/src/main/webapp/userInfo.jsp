<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.UserInfo" %>	
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	if(username==null)
		username="test";
	//HttpSession session = request.getSession(); 取得 HttpSession
	session.setMaxInactiveInterval(120); //設定其過期的時限為 2分鐘
	UserInfo user = UserInfo.getInstance();
	//ArrayList list = user.getList(); 取得存放所有用戶的 Vector
	model.UserInfoBinding usb = new model.UserInfoBinding();
	usb.setUsername(username);
	user.addUser(username); //加入至 list
	session.setAttribute("user", usb); //此處發生 binding
	out.println("online user :"+username);
	session.invalidate();
	out.println("offline user :"+username);
	%>
</body>
</html>