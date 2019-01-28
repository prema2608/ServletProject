
package com.bridgelabz.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class WelcomePageServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		        HttpSession session = req.getSession(false);
//				  String name1 = (String) session.getAttribute("value"); 
//				 session.removeAttribute(name1);
//					  req.setAttribute("Error", "Session has ended. Please login.");
//				  RequestDispatcher rd = req.getRequestDispatcher("/LoginPage.html"); 
//				  rd.forward(req, resp);
		resp.setContentType("text/html");
    	Cookie[] cookies = req.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    			break;
    		}
    	}
    	}
    	//invalidate the session if exists
    	HttpSession session = req.getSession(false);
    	System.out.println("User="+session.getAttribute("uname"));
    	if(session != null){
    		session.invalidate();
    	}
    	resp.sendRedirect("LoginPage.html");
	}
}
