package com.myprojects.servlet;

import  com.myprojects.beans.*;
import com.myprojects.dao.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class IssueBookForm extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");	
		String colNo = request.getParameter("colno");
		String studentId = request.getParameter("studentid");
		String studentName = request.getParameter("studentname");
		String studentMobile = request.getParameter("studentmobile");
		long mobile = Long.valueOf(studentMobile);
		IssuedBook issueBook = new IssuedBook(colNo, studentId, studentName, mobile);
		int status = BookDao.issueBook(issueBook);
		if(status > 0) {
			out.println("<h3>Book issued successfully.</h3>");
		} else {
			out.println("<h3>sorry, unable to issue book</h3>");
		}
	}
}
