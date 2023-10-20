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
		BankDAO dao = new BankDAOimpl();
		BankDAOimpl impl = new BankDAOimpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//int accountNo;
		try {
		//	accountNo = impl.getAccountNumber(username, password);
			if(dao.loginDao(username, password)==1) {
				
				Bank bank = impl.searchAccountDao(username);
				HttpSession session=request.getSession(true);
				session.setAttribute("accno",bank.getAccountNo());
				RequestDispatcher disp = request.getRequestDispatcher("Home.html");
				disp.forward(request, response);
			}
			else {
				RequestDispatcher disp = request.getRequestDispatcher("Login.html");
				disp.include(request, response);
				out.println("Invalid Credentials! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			}
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
