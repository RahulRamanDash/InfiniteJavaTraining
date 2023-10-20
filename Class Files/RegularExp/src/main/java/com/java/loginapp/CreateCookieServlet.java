package com.java.loginapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CreateCookieServlet
 */
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie1 = new Cookie("Jitendra","87");
		cookie1.setMaxAge(1000*60*60*24);
		response.addCookie(cookie1);
		Cookie cookie2 = new Cookie("Rahul","88");
		cookie2.setMaxAge(1000*60*60*24);
		response.addCookie(cookie2);
		Cookie cookie3 = new Cookie("Sourav","8");
		cookie3.setMaxAge(1000*60*60*24);
		response.addCookie(cookie3);
		PrintWriter out = response.getWriter();
		out.println("Cookies are Created....");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
