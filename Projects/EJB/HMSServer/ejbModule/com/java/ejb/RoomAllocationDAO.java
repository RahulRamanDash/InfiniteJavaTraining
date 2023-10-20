package com.java.ejb;

import java.sql.SQLException;

public interface RoomAllocationDAO {
	String allocateRoomDao(RoomAllocation room) throws ClassNotFoundException, SQLException;
}
