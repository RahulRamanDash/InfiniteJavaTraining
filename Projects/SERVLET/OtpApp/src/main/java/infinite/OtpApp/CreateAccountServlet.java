package infinite.OtpApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		OtpAppDAO dao = new OtpAppDaoImpl();
		Customer customer = new Customer();
		customer.setCustomer_FirstName(request.getParameter("fname"));
		customer.setCustomer_LastName(request.getParameter("lname"));
		customer.setCustomer_UserName(request.getParameter("user"));
		customer.setCustomer_Password(request.getParameter("pass"));
		customer.setCustomer_Email(request.getParameter("email"));
		customer.setCustomer_PhoneNo(request.getParameter("phoneno"));
		try {
				out.println("<center> <div style=\"margin-top: 20px;\">"+dao.createAccountDao(customer)+"</div></center>");
				RequestDispatcher disp = request.getRequestDispatcher("ValidateOtp.html");
				disp.include(request, response);
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
