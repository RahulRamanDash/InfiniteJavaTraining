package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DoctorMasterDaoImpl implements DoctorMasterDAO{
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<DoctorMaster> showDoctorDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * From Doctor_Master";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<DoctorMaster> doctorList = new ArrayList<>();
			DoctorMaster doctor = null;
			while(rs.next()) {
				doctor = new DoctorMaster();
				doctor.setDrId(rs.getString("Dr_id"));
				doctor.setDrName(rs.getString("Dr_name"));
				doctor.setDept(rs.getString("Dept"));
				doctorList.add(doctor);
			}
		return doctorList;
	}

}
