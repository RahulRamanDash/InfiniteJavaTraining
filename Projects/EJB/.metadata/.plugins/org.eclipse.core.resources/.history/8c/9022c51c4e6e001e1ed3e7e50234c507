package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMasterDaoImpl implements PatientMasterDAO{

	Connection connection;
	PreparedStatement pst;
	
	public String incrimentpatientId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select max(pid) as pid from patient_master";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			String pid = rs.getString("pid");
			String numstr = pid.substring(1);
			int num = Integer.parseInt(numstr);
			num+=1;
			String patientId = String.format("P%04d", num);
			return patientId;
		}else {
			return "P0001";
		}
	}
	
	@Override
	public String addPatient(PatientMaster patient) throws ClassNotFoundException, SQLException {
		String patientId = incrimentpatientId();
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Patient_Master(pid,name,age,weight,gender,address,phoneno,disease,doctor_id)" +"VALUES (?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, patientId);
		pst.setString(2, patient.getName());
		pst.setInt(3, patient.getAge());
		pst.setInt(4, patient.getWeight());
		pst.setString(5, patient.getGender().toString());
		pst.setString(6, patient.getAddress());
		pst.setString(7, patient.getPhoneNo());
		pst.setString(8, patient.getDisease());
		pst.setString(9, patient.getDoctorId());
		
		pst.executeUpdate();
		return "Data Inserted To the Table";
	}
	

}
