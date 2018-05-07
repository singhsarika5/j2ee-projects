package com.myprojects.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminLogin extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome tp Library.");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email.equals("admin123@ins.com") && password.equals("admin123")) {

			HttpSession session = request.getSession();
			session.setAttribute("admin", true);
			request.getRequestDispatcher("admin.html").include(request, response);
		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<p> " + "Email or Password entered is not correct." + "</p>");

			out.println("</body>");
			out.println("</html>");
		}

	}

}
