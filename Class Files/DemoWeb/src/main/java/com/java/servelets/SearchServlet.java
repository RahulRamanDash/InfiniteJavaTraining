package com.java.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		int empno = Integer.parseInt(request.getParameter("empno"));
		PrintWriter out = response.getWriter();
		EmployDAO dao = new EmployDAOimpl();
		
		try {
			Employ employ =dao.searchEmployDao(empno);
			if (employ!=null) {
				out.println("Employ No : "+employ.getEmpno());
				out.println("Employ Name : "+employ.getName());
				out.println("Gender : "+employ.getGender());
				out.println("Department : "+employ.getDept());
				out.println("Designation : "+employ.getDesig());
				out.println("Salary : "+employ.getBasic());
				out.println("--------------------------------");
			}else {
				out.println("***Employ Record Not Found***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

}
