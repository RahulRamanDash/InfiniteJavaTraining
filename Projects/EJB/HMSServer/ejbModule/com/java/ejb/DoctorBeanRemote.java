package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface DoctorBeanRemote {
	List<DoctorMaster> showDoctor() throws ClassNotFoundException, SQLException;
}
