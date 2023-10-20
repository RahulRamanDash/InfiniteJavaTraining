package com.java.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		
		String pass = request.getParameter("passcode");
		String repass = request.getParameter("repasscode");
		if(pass.equals(repass)) {
			Login login = new Login();
			login.setUserName(request.getParameter("username"));
			login.setPassCode(request.getParameter("passcode"));
			
			try {
				LoginDAO dao = new LoginDaoImpl();
				out.println(dao.createUser(login));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else {
			out.println("Password Must be Same");
		}
	}

}
