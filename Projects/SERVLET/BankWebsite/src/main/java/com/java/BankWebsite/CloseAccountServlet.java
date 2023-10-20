package com.java.BankWebsite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CloseAccountServlet
 */
public class CloseAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		BankDAO dao = new BankDAOimpl();
		PrintWriter out = response.getWriter();
		int accno = (Integer) session.getAttribute("accno");
		String checkval = request.getParameter("box");

		if(checkval.equals("yes")){
			try {
				out.println(dao.closeAccountDao(accno));
				RequestDispatcher disp = request.getRequestDispatcher("Login.html");
				disp.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else {
			RequestDispatcher disp = request.getRequestDispatcher("Home.html");
			disp.include(request, response);
			out.println("Happy To See You Again...");
		}
		
		
	}

}
