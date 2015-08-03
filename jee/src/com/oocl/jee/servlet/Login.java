package com.oocl.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.jee.pojo.User;
import com.oocl.jee.service.UserMng;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		User user = UserMng.doLogin(name, psw);

		if (user == null) {
			response.sendRedirect("index.html");
		} else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("success.jsp");
		}
	}

}