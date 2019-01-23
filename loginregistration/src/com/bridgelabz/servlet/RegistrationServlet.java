package com.bridgelabz.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet
	{
		public void doPost(HttpServletRequest request , HttpServletResponse response)
		{
			
			String name = request.getParameter("name");
			System.out.println(name);
			String password = request.getParameter("password");
			System.out.println(password);
			String email = request.getParameter("email");
			System.out.println(email);
			String confrmpaswrd = request.getParameter("confrmpaswrd");
			System.out.println(confrmpaswrd);
			long pnum = Long.parseLong(request.getParameter("pnum"));
			System.out.println(pnum);
			
			User us = new User(name, email, pnum, password, confrmpaswrd);
		}
}
