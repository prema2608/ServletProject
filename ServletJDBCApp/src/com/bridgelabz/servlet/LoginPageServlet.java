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
public class LoginPageServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
	{
		String name = req.getParameter("name");
		System.out.println(name);
		String password = req.getParameter("password");
		System.out.println(password);
		RequestDispatcher rdObj = null;


		PrintWriter out = resp.getWriter();

		out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
		
		// Creating The 'RequestDispatcher' Object For Forwading The HTTP Request
		
		// Checking For Null & Empty Values
		if(name == null || password == null || "".equals(name) || "".equals(password)) {
			
			//HttpSession  session = req.setAttribute("user", name);
			
			out.write("<p id='errMsg' style='color: red; font-size: larger;'>Please Enter Both Username & Password... !</p>");

			rdObj = req.getRequestDispatcher("/LoginPage.html");

			rdObj.include(req, resp);

		} else {
			

			System.out.println("Username?= " + name + ", Password?= " + password);
			
			// Authentication Logic & Building The Html Response Code
			//if((name.equalsIgnoreCase("prema")) && (password.equals("dogslove"))) {

				
			if((name.equalsIgnoreCase(name)) && (password.equals(password))) {
				HttpSession session = req.getSession(true);
				session.setAttribute("value", name);
				
				rdObj = req.getRequestDispatcher("/WelcomePage.html");

				rdObj.forward(req, resp);                   

			} else {

				out.write("<p id='errMsg' style='color: red; font-size: larger;'>You are not an authorised user! Please check with administrator!</p>");

				rdObj = req.getRequestDispatcher("/LoginPage.html");

				rdObj.include(req, resp);

			}           

		}

		out.write("</div></body></html>");

		out.close();

	}



}




