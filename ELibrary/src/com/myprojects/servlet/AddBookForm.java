package com.myprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.myprojects.beans.*;
import com.myprojects.dao.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class AddBookForm extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("</head>");
		out.println("<body>");
		String colNo = request.getParameter("colno");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String squantity = request.getParameter("quantity");
		int quantity = Integer.valueOf(squantity);
		Book b1 = new Book(colNo, name, author, publisher, quantity);
		int status = BookDao.save(b1);
		if ( status > 0 ){
			out.println("<h3>Book saved Successfully.</h3>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
