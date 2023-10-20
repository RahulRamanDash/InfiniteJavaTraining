package infinite.OtpApp;

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
 * Servlet implementation class ResetPasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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
		 
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		
			OtpAppDAO dao = new OtpAppDaoImpl();
			String resetKey = request.getParameter("resetKey");
			String newPass = request.getParameter("newPass");
			String renewPass = request.getParameter("renewPass");
			if(newPass.equals(renewPass)) {
				
			try {
					out.println("<center> <div style=\"margin-top: 20px;\">"+dao.resetPasswordDao(username,resetKey,renewPass)+"</div></center>");
					RequestDispatcher disp = request.getRequestDispatcher("Login.html");
					disp.include(request, response);
					
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			}
	}

}
