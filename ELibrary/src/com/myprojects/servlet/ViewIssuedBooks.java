package com.myprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.myprojects.beans.IssuedBook;
import com.myprojects.dao.BookDao;

public class ViewIssuedBooks extends HttpServlet {

	public void doGet(HttpServletRequest requestm, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<IssuedBook> list = BookDao.viewIssuedBook();
	
		out.println("<html>");
		out.println("<head>");
		out.println("<h3>Below is the list of all issued Books</h3>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border= '1'>");
		out.println("<tr><th>ColNo</th><th> Student Id</th><th>Student Name</th><th>Mobile No.</th><th>Issue Date</th><th>Return Date</th></tr>");
		for(IssuedBook bean : list) {
			out.println("<tr><td>" + bean.getColNo() + "</td><td>" + bean.getStudentId() + "</td><td>" + bean.getStudentName() + "</td><td>" + bean.getStudentMobile() + "</td><td>" + bean.getIssuedDate() + "</td><td>" + bean.getReturnStatus()); 
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
}
