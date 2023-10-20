package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomMasterDaoImpl implements RoomMasterDAO{

	Connection connection;
	PreparedStatement pst;

	@Override
	public List<String> showRoomTypeDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select distinct room_type from room_master";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<String> roomTypeList = new ArrayList<>();
			String roomType = null;
			while(rs.next()) {
				roomType = rs.getString("room_type");
				roomTypeList.add(roomType);
			}
		return roomTypeList;
	}

	@Override
	public List<String> showRoomNoDao(String roomType) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select room_no from room_master where room_type=? and status = 'VACANT'";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, roomType);
			ResultSet rs = pst.executeQuery();
			List<String> roomNoList = new ArrayList<>();
			String roomNo = null;
			while(rs.next()) {
				roomNo = rs.getString("room_no");
				roomNoList.add(roomNo);
			}
		return roomNoList;
	}
	
}
