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
 * Servlet implementation class DepositAmountServlet
 */
public class DepositAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositAmountServlet() {
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
		response.setContentType("text/html");
	    HttpSession session = request.getSession(true);
	      
	    PrintWriter out = response.getWriter();
	    BankDAO dao = new BankDAOimpl();
	    int amount = Integer.parseInt(request.getParameter("depositamount"));
	    int accno = (Integer) session.getAttribute("accno");
	    
	    try {
	    	out.println("<center>"+dao.depositAmountDao(accno, amount)+"</center>");
	    	out.println("<center>"+dao.checkBalenceDao(accno)+"</center>");
			RequestDispatcher disp = request.getRequestDispatcher("DepositAmount.html");
			disp.include(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
