package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RoomAllocationBeanRemote {
	String allocateRoom(RoomAllocation room) throws ClassNotFoundException, SQLException;
}
