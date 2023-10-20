package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DoctorBean
 */
@Stateless
@Remote(DoctorBeanRemote.class)
public class DoctorBean implements DoctorBeanRemote {
	
	static DoctorMasterDAO doctorDao;
	static {
		doctorDao = new DoctorMasterDaoImpl();
	}
    /**
     * Default constructor. 
     */
    public DoctorBean() {
    }

	@Override
	public List<DoctorMaster> showDoctor() throws ClassNotFoundException, SQLException {
		return doctorDao.showDoctorDao();
	}



}
