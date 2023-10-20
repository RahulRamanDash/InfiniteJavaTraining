package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RoomMasterBeanRemote {
	List<String> showRoomType() throws ClassNotFoundException, SQLException;
	List<String> showRoomNo(String roomType) throws ClassNotFoundException, SQLException;
}
