package com.bridgelabz.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dbutil.MyDbaseApp;
import com.bridgelabz.model.User;

@SuppressWarnings("serial")
public class EditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("uname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long mobileNumber =Long.parseLong(req.getParameter("pnumb"));
		System.out.println(email);
		System.out.println(password);
		System.out.println(mobileNumber);

		if (email.equals("") || password.equals("") || mobileNumber==0) {
			resp.sendRedirect("Edit.jsp");
		} else {
			user.setPnumb(mobileNumber);
			user.setEmail(email);
			user.setPassword(password);
			try {
				System.out.println(user.getName());
				MyDbaseApp.edit(user);
				resp.sendRedirect("PersonProfile.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}