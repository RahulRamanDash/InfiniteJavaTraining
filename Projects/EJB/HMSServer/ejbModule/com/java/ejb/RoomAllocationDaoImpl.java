package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class RoomAllocationDaoImpl implements RoomAllocationDAO{

	Connection connection;
	PreparedStatement pst;

	@Override
	public String allocateRoomDao(RoomAllocation room) throws ClassNotFoundException, SQLException {
		Date date = new Date();
		java.sql.Date currentDate = (java.sql.Date)date;
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Room_Allocation(room_no,pid,admission_date)" + "VALUES (?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, room.getRoomNo());
		pst.setString(2, room.getPid());
		pst.setDate(3, currentDate);
		
		pst.executeUpdate();
		return "Data Inserted To the Table";
	}


}
