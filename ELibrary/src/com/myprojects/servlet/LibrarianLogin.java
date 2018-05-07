package com.myprojects.servlet;

import com.myprojects.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;


public class LibrarianLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(LibrarianDao.authenticate(email, password)) {
			request.getRequestDispatcher("librariansection.html").include(request, response);
		} else {
			out.println("Email or password is incorrect.");
		}
		
	}

}
