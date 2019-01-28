<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sessionID=null;
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("uname")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("LoginPage.html");
%>
<h3>Hi <%=userName %>, Login successful.<br>Your Session ID=<%=sessionID %></h3>
<br>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>