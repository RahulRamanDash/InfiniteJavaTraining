package com.java.ejb;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class EmployEjbImpl {

	public List<Employ> showEmployEjb() throws NamingException, ClassNotFoundException, SQLException {
	 EmployJdbcBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
	 return remote.showEmploy();
	}
	public String searchEmployEjb(int empno) throws NamingException, ClassNotFoundException, SQLException {
		 Map<String, Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		EmployJdbcBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		Employ employ = remote.searchEmploy(empno);
		sessionMap.put("editEmploy", employ);
		return "UpdateEmploy.jsp?faces-redirect=true";
	}
	public String updateEmployEjb(Employ editEmploy) throws NamingException, ClassNotFoundException, SQLException {
		 EmployJdbcBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		 remote.updateEmploy(editEmploy);
		 return "EmployDaoTable.jsp?faces-redirect=true";
		}
	public String deleteeEmployEjb(int empno) throws NamingException, ClassNotFoundException, SQLException {
		 EmployJdbcBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		 remote.deleteEmploy(empno);
		 return "EmployDaoTable.jsp?faces-redirect=true";
		}
	
	public String addEmployEjb(Employ employNew) throws NamingException, ClassNotFoundException, SQLException {
		EmployJdbcBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		remote.addEmploy(employNew);
		return "EmployDaoTable.jsp?faces-redirect=true";
	}
	
	
}
