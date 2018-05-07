package com.myprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import com.myprojects.dao.BookDao;

public class ReturnBook extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String colNo = request.getParameter("colno");
		String studentId = request.getParameter("studentid");
		
		int status = BookDao.returnBook(colNo, studentId);
		if(status > 0) {
			out.println("<h3>Book Returned successfully.</h3>");
		} else {
			out.println("<h3>Unable to return book.</h3>");
		}
	}

}
