package com.bridgelabz.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dbutil.MyDbaseApp;
import com.bridgelabz.model.User;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		System.out.println(name);
		String password = request.getParameter("password");
		System.out.println(password);
		String email = request.getParameter("email");
		System.out.println(email);
		long pnumb = Long.parseLong(request.getParameter("pnumb"));
		System.out.println(pnumb);

		User us = new User(0,name, email, pnumb, password);

		try {
			MyDbaseApp.registration(us);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Something wrong");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
		rd.forward(request, response);
	}
}
