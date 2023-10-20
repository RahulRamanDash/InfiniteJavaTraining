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
 * Servlet implementation class WithdrawAmount
 */
public class WithdrawAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawAmountServlet() {
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
	    int accno = (Integer) session.getAttribute("accno");
	      
	    PrintWriter out = response.getWriter();
	    BankDAO dao = new BankDAOimpl();
	    int amount = Integer.parseInt(request.getParameter("withdrawamount"));
	    
	    try {
	    	out.println("<center>"+dao.withdrawAmountDao(accno, amount)+"</center>");
	    	out.println("<center>"+dao.checkBalenceDao(accno)+"</center>");
			RequestDispatcher disp = request.getRequestDispatcher("WithdrawAmount.html");
			disp.include(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
