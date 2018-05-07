package com.myprojects.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myprojects.beans.Librarian;
import com.myprojects.dao.LibrarianDao;


public class ViewRegisteredLibrarian extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Librarian</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
		
		List<Librarian> list = LibrarianDao.view();
		for(Librarian obj1:list) {
			out.println("<tr><td>" + obj1.getID() + "</td><td>" + obj1.getName() + "</td><td>" + obj1.getEmail() +"</td><td>" + obj1.getPassword() + "</td><td>" + obj1.getMobile() + "</td><td><a href='editlibrarianform?id=" + obj1.getID() + "'>Edit</td>" + "</td><td><a href='deletelibrarian?id=" + obj1.getID() + "'>Delete</td>" + "</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");	
	}
}
