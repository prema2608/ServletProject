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
public class ProfileServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rdObj = null;
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			String name1 = (String) session.getAttribute("value");
			session.removeAttribute(name1);

			out.write("<b>HELLO, " + name1 + " WELCOME TO PROFILE</b><br>");
			out.write("<a href=ProfilePage.html>go back to profile page</a>");
//			out.write("<input type=\"submit\" value=\"logout\" />");
//			rdObj=req.getRequestDispatcher("/WelcomePage.html");
//			rdObj.forward(req, resp);
			out.close();
		}
		
	}
}
