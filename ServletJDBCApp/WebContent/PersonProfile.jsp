<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@page import ="com.bridgelabz.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProfileJsp</title>
</head>
<body>
	<%
	User user = null;
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("LoginPage.html");
	} else
	{
			user =(User)(session.getAttribute("uname"));
	}
		String sessionID = null;
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uname"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("LoginPage.html");
	%>
	<h3>
		Hi
		<%=userName%></h3>
	<br>
	Your name:<%=user.getName()%>
	<br>
   Your	email:<%=user.getEmail()%>
	<br>
   Your	phn no:<%=user.getPnumb()%>
	
	<form action="<%=response.encodeURL("Edit.jsp") %>" method="post">
		<input type="submit" value="edit">
	</form>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>