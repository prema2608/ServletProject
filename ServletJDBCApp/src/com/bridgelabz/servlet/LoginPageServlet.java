package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dbutil.MyDbaseApp;
import com.bridgelabz.model.User;

@SuppressWarnings("serial")
public class LoginPageServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
	{
		String name = req.getParameter("name");
		System.out.println(name);
		String password = req.getParameter("password");
		System.out.println(password);
		RequestDispatcher rdObj = null;
		User user=new User(0,name,null,0,password);
		PrintWriter out = resp.getWriter();

		out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");

		// Creating The 'RequestDispatcher' Object For Forwarding The HTTP Request
		if(name == null || password == null || "".equals(name) || "".equals(password)) {

			//HttpSession  session = req.setAttribute("user", name);

			out.write("<p id='errMsg' style='color: red; font-size: larger;'>Please Enter Both Username & Password... !</p>");

			rdObj = req.getRequestDispatcher("/LoginPage.html");

			rdObj.include(req, resp);

		}
		
		else
		{
			try {
				User user2=MyDbaseApp.retriveValue(user);
				if(user2!=null)
				{
					HttpSession session = req.getSession(true);
					session.setAttribute("uname", user2);
					Cookie loginCookie = new Cookie("uname",name);
					//setting cookie to expire in 30 mins
					loginCookie.setMaxAge(30*60);
					resp.addCookie(loginCookie);
					rdObj = req.getRequestDispatcher("/ProfilePage.jsp");
					rdObj.forward(req, resp);
					
				}
				   
				else
				{
					out.write("<p id='errMsg' style='color: red; font-size: larger;'>You are not an authorised user! Please check with administrator!</p>");

					rdObj = req.getRequestDispatcher("/LoginPage.html");

					rdObj.include(req, resp);

				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}



}




