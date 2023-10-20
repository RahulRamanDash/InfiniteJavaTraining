package com.java.regularexp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String firstname, lastname;
		if(user.equals("rahul") && pass.equals("rahul")) {
			firstname = "Rahul";
			lastname = "Raman";
			out.println("<a href = 'WelcomeServlet?firstName="+firstname+"&lastName="+lastname+" ' >Welcome<a/>");
		}
		if(user.equals("sonali") && pass.equals("sonali")) {
			firstname = "Sonali";
			lastname = "Sahu";
			out.println("<a href = 'WelcomeServlet?firstName="+firstname+"&lastName="+lastname+" ' >Welcome<a/>");
		}
		if(user.equals("ganu") && pass.equals("ganu")) {
			firstname = "Ganesh";
			lastname = "Mirda";
			out.println("<a href = 'WelcomeServlet?firstName="+firstname+"&lastName="+lastname+" ' >Welcome<a/>");
		}
	}

}
