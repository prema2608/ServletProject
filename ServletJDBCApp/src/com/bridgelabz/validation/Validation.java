package com.bridgelabz.validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Validation implements Filter
{
	static final String REGEX_EMAIL_ID = "^[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
	static final String REGEX_CONTACT = "^[0-9]{10}";


	public void init(FilterConfig filterConfig) throws ServletException {   }


	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chainObj) throws IOException, ServletException
	{
		RequestDispatcher rdObj = null;
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		String email=req.getParameter("email");
		String telNo = req.getParameter("pnumb");
		if(email.matches(REGEX_EMAIL_ID)&& telNo.matches(REGEX_CONTACT))
		{
			chainObj.doFilter(req, resp);
		}
		else
		{
			out.println("Not a valid credential");
			rdObj=req.getRequestDispatcher("RegisterPage.html");
			rdObj.include(req, resp);
		}
		out.println("<html><body>");
		out.close();
	}
	public void destroy() {}
}

