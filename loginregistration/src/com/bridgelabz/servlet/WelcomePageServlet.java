package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class WelcomePageServlet extends HttpServlet
	{
		public void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
		{
		        HttpSession session = req.getSession(false);
				  String name1 = (String) session.getAttribute("value"); 
				 session.removeAttribute(name1);
					  req.setAttribute("Error", "Session has ended. Please login.");
				  RequestDispatcher rd = req.getRequestDispatcher("/LoginPage.html"); 
				  rd.forward(req, resp);
					  
				        //resp.sendRedirect("/LoginPage.html");
					  } 
			}



