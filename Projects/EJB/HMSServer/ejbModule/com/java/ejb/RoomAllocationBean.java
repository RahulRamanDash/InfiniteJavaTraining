package com.java.ejb;

import java.sql.SQLException;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RoomAllocationBean
 */
@Stateless
@Remote(RoomAllocationBeanRemote.class)
public class RoomAllocationBean implements RoomAllocationBeanRemote {
	
	static RoomAllocationDAO roomDao;
	
	static {
		roomDao = new RoomAllocationDaoImpl();
	}
	
    /**
     * Default constructor. 
     */
    public RoomAllocationBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String allocateRoom(RoomAllocation room) throws ClassNotFoundException, SQLException {
		return roomDao.allocateRoomDao(room);
	}

}