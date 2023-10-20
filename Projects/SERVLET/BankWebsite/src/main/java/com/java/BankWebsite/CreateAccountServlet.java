package com.java.BankWebsite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.ITypeAnnotationWalker;

/**
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
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
		String firstname = request.getParameter("fname");
		String lasttname = request.getParameter("lname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String cheqfacil = request.getParameter("cheqfacil");
		String accounttype = request.getParameter("accounttype");
		Bank bank = new Bank();
		bank.setFirstName(firstname);
		bank.setLastName(lasttname);
		bank.setCity(city);
		bank.setState(state);
		bank.setAmount(amount);
		bank.setCheqFacil(cheqfacil);
		bank.setAccountType(accounttype);
		BankDAO dao = new BankDAOimpl();
		try {
			out.println(dao.createAccountDAO(bank));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
