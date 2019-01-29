
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@page import ="com.bridgelabz.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div id="register" class="animate form">
			<form  action ="edit" method="post"> 
				<h1> Sign up </h1> 
				
				<p> 
					<label for="email" class="email" data-icon="e" > Your email</label>
					<input id="email" name="email" required="required" type="email" placeholder="mysupermail@mail.com"/> 
				</p>
				<p> 
					<label for="password" class="password" data-icon="p">Your password </label>
					<input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
				</p>
				<p> 
					<label for="pnum" class="pnum" data-icon="p">Your Pnumber </label>
					<input id="pnumb" name="pnumb" required="required" type="number" placeholder="eg. 1234567890"/>
				</p>
				
				<p class="signin button"> 
					<input type="submit" value="save"/> 
				</p>
			</form>
		</div>


</body>
</html>