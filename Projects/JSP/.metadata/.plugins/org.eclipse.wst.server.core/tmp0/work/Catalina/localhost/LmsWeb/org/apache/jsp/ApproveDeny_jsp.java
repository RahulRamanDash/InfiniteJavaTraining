/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2023-09-26 19:33:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.java.infinite.Employee;
import com.java.infinite.EmployeeDAOImpl;
import com.java.infinite.EmployeeDAO;
import com.java.infinite.LeaveDetails;
import com.java.infinite.LeaveDetailsDAOImpl;
import com.java.infinite.LeaveDetailsDAO;

public final class ApproveDeny_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.java.infinite.LeaveDetails");
    _jspx_imports_classes.add("com.java.infinite.Employee");
    _jspx_imports_classes.add("com.java.infinite.EmployeeDAOImpl");
    _jspx_imports_classes.add("com.java.infinite.LeaveDetailsDAOImpl");
    _jspx_imports_classes.add("com.java.infinite.LeaveDetailsDAO");
    _jspx_imports_classes.add("com.java.infinite.EmployeeDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("    body {\r\n");
      out.write("        background-color: #f0f0f0; /* Light Gray Background */\r\n");
      out.write("        font-family: Arial, sans-serif;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("        background-color: #ffffff; /* White Container */\r\n");
      out.write("        border-radius: 8px;\r\n");
      out.write("        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        margin: 20px auto;\r\n");
      out.write("        width: 80%;\r\n");
      out.write("        max-width: 600px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h1 {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        color: #333; /* Dark Gray Text */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\ttable.form-table td {\r\n");
      out.write("        padding: 4px; /* Decreased padding */\r\n");
      out.write("        margin: 2px 0; /* Decreased margin */\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    table.form-table {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    table.form-table tr {\r\n");
      out.write("        vertical-align: top;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    table.form-table td {\r\n");
      out.write("        padding: 4px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    label {\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"text\"], select {\r\n");
      out.write("        width: 90%;\r\n");
      out.write("        padding: 12px;\r\n");
      out.write("        margin: 5px 0;\r\n");
      out.write("        border: 1px solid #ccc;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"text\"]:focus, select:focus {\r\n");
      out.write("        border-color: #007bff; /* Blue on Focus */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    select {\r\n");
      out.write("        width: %;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .button-container {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        margin-top: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"submit\"] {\r\n");
      out.write("        background-color: #007bff; /* Blue Button */\r\n");
      out.write("        color: #fff;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        padding: 12px 20px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        transition: background-color 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"submit\"]:hover {\r\n");
      out.write("        background-color: #0056b3; /* Darker Blue on Hover */\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

    if (request.getParameter("leaveId")!=null) {
         int leaveId = Integer.parseInt(request.getParameter("leaveId"));
         session.setAttribute("leaveId", request.getParameter("leaveId"));
    }
//  out.println(leaveId);
    String id = (String)session.getAttribute("leaveId");
    int leId = Integer.parseInt(id);
    LeaveDetailsDAO dao = new LeaveDetailsDAOImpl();
    LeaveDetails leave = dao.searchLeaveDao(leId);
    int empId = leave.getEmpId();
    EmployeeDAO edao = new EmployeeDAOImpl();
    Employee employee = edao.searchEmployeeDao(empId);
    

      out.write("\r\n");
      out.write("    <center>\r\n");
      out.write("   <form action=\"ApproveDeny.jsp\" method=\"post\" class=\"container\">\r\n");
      out.write("    <h1>Leave Approval Form</h1>\r\n");
      out.write("    <table class=\"form-table\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"leave_id\">Leave ID:</label></td>\r\n");
      out.write("            <td>");
      out.print(leave.getLeaveId() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"employee_id\">Employee ID:</label></td>\r\n");
      out.write("            <td>");
      out.print(empId );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"employee_name\">Employee Name:</label></td>\r\n");
      out.write("            <td>");
      out.print(employee.getEmpName() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"leave_balance\">Leave Balance:</label></td>\r\n");
      out.write("            <td>");
      out.print(employee.getLeaveAvail() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"start_date\">Start Date:</label></td>\r\n");
      out.write("            <td>");
      out.print(leave.getLeaveStartDate() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"end_date\">End Date:</label></td>\r\n");
      out.write("            <td>");
      out.print(leave.getLeaveEndDate() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"no_of_days\">No. of Days:</label></td>\r\n");
      out.write("            <td>");
      out.print(leave.getNoOfDays() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"leave_type\">Leave Type:</label></td>\r\n");
      out.write("            <td>");
      out.print(leave.getLeaveType() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"leave_reason\">Reason:</label></td>\r\n");
      out.write("            <td>");
      out.print(leave.getLeaveReason() );
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"leave_status\">Leave Status:</label></td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <select name=\"status\">\r\n");
      out.write("                    <option value=\"YES\">YES</option>\r\n");
      out.write("                    <option value=\"NO\">NO</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><label for=\"manager_comment\">Manager Comment:</label></td>\r\n");
      out.write("            <td><input type=\"text\" name=\"mgcmt\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <div class=\"button-container\">\r\n");
      out.write("        <input type=\"submit\" value=\"Submit\">\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("    </center>\r\n");
      out.write("    ");

    if(request.getParameter("status")!=null && request.getParameter("mgcmt")!=null){
    String status = request.getParameter("status");
    String mgcmt = request.getParameter("mgcmt");
    
    out.println(dao.ApproveDeny(leave.getLeaveId(), employee.getManagerId(), status, mgcmt));
    
      out.write("\r\n");
      out.write("    ");
      if (true) {
        _jspx_page_context.forward("EmployShow.jsp");
        return;
      }
      out.write("\r\n");
      out.write("    ");

    }
    
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}