package com.myprojects.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myprojects.dao.LibrarianDao;
import com.myprojects.beans.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class EditLibrarianForm extends HttpServlet {

		
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Edit Library Form</title>");			
			out.println("</head>");
			out.println("<body>");
			String sid = request.getParameter("id");
			int id = Integer.valueOf(sid);
			Librarian bean = LibrarianDao.viewById(id);
			out.println("<form method='POST' action='editlibrarian'>");
			out.println("Id<br/><input type='text' size ='2' name='id' value='" + bean.getID() + "'/><br/>");
			out.println("Name<br/><input type='text' size ='20' name='name' value='" + bean.getName() + "'/><br/>");
			out.println("Email<br/><input type='text' size ='30' name='email' value='" + bean.getEmail() + "'/><br/>");
			out.println("Password<br/><input type='text' size ='10' name='password' value='" + bean.getPassword() + "'/>");
			out.println("Mobile<br/><input type='text' size ='10' name='mobile' value='" + bean.getMobile() + "/>");
			out.println("<input type='submit'value='Update'");
			out.println("</form>");
			out.println("<p>footer</p>");
			out.println("</body>");
			out.println("</html>");
		}
}
