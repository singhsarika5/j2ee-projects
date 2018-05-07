package com.myprojects.servlet;

import com.myprojects.dao.*;
import com.myprojects.beans.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


public class AddNewLibrarian extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");

		
		Long mobileNo = Long.valueOf(mobile);
		int librarianId = Integer.valueOf(id);
		Librarian newLibrarian = new Librarian(librarianId,name, email, password,mobileNo);
		if (LibrarianDao.save(newLibrarian) != 0) {
			out.println("Librarian added successfully."); }
		else {
			out.println("Librarian not added."); }
		}
		
}
	
