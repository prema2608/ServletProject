package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcomeServlet")

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// This Method Is Called By The Servlet Container To Process A 'POST' Request.

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		handleRequest(req, resp);

	}public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		// Post Parameters From The Request

		String name = req.getParameter("name");
		String logout = req.getParameter("logout");
	//	String password = req.getParameter("password");
		// Building & Printing The HTML Response Code

		PrintWriter out = resp.getWriter();

		out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");

		out.write("<h2>WELCOME HOME</h2>");

		out.write("<p style='color: green; font-size: large;'>Congratulations! <span style='text-transform: capitalize;'>" + name + "</span>, You are an authorised login!</p>");

		out.write("</div></body></html>");

		out.close();
        HttpSession session = req.getSession(false);
		  String name1 = (String) session.getAttribute("value"); 
		  if (null == name1) 
		  { 
			  req.setAttribute("Error", "Session has ended. Please login.");
			  RequestDispatcher rd = req.getRequestDispatcher("/LoginPage.html"); 
			  rd.forward(req, resp);
			  } 
	}

}


