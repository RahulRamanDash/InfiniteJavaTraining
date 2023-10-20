package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public class DoctorEjbImpl {
	public List<DoctorMaster> showDoctorsEjb() throws NamingException, ClassNotFoundException, SQLException {
		 DoctorBeanRemote remote = DoctorRemoteHelper.lookupRemoteStatelessEmploy();
		 return remote.showDoctor();
		}
}
