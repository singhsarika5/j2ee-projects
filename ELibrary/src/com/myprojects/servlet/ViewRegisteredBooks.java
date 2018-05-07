package com.myprojects.servlet;

import com.myprojects.beans.Book;
import com.myprojects.dao.BookDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class ViewRegisteredBooks extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<h3>Below is the list of all registered Books</h3>");
		out.println("</head>");
		out.println("<body>");
		
		List<Book> list= BookDao.view();
		out.println("<table border= '1'>");
		out.println("<tr><th>ColNo</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		for(Book bean : list) {
			out.println("<tr><td>" + bean.getColNo() + "</td><td>" + bean.getName() + "</td><td>" + bean.getAuthor() + "</td><td>" + bean.getPublisher() + "</td><td>" + bean.getQuantity() + "</td><td>" + bean.getIssued() +  "</td><td><a href = 'deletebook?colNo=" + bean.getColNo() + "'>Delete</a></td></tr>");
		} 
		out.println("</table>"); 
		out.println("</body>");
		out.println("</html>");
	}

}
