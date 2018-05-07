package com.myprojects.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class LogoutAdmin extends HttpServlet {
	
	public void doGet(HttpServletRequest requrest, HttpServletResponse response) throws IOException, ServletException {
		requrest.getSession().invalidate();
		response.sendRedirect("libraryhome.html");	
	}
}
