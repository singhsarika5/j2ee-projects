package com.myprojects.servlet;

import com.myprojects.beans.*;
import com.myprojects.dao.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteLibrarian extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		LibrarianDao.delete(id);
		response.sendRedirect("viewlibrarian");
	}

}
