package com.myprojects.servlet;

import com.myprojects.beans.Librarian;
import com.myprojects.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


public class EditLibrarian extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		long mobileNo = Long.valueOf(mobile);
		Librarian l1 = new Librarian(id,name, email, password, mobileNo);
		LibrarianDao.update(l1);
			
	}
}
