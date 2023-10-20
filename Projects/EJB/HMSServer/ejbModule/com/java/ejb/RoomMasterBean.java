package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RoomMasterBean
 */
@Stateless
@Remote(RoomMasterBeanRemote.class)
public class RoomMasterBean implements RoomMasterBeanRemote {
	static RoomMasterDAO roommasterDao;
	
	static {
		roommasterDao = new RoomMasterDaoImpl();
	}
    /**
     * Default constructor. 
     */
    public RoomMasterBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<String> showRoomType() throws ClassNotFoundException, SQLException {
		return roommasterDao.showRoomTypeDao();
	}


	@Override
	public List<String> showRoomNo(String roomType) throws ClassNotFoundException, SQLException {
		return roommasterDao.showRoomNoDao(roomType);
	}

}
