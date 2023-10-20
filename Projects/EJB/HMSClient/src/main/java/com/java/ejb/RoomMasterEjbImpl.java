package com.java.ejb;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.naming.NamingException;

public class RoomMasterEjbImpl {
	
	private String roomType;

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	private String roomNo;
	
	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public void roomTypeChanged(ValueChangeEvent e) {
		this.roomType = e.getNewValue().toString();
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("roomType", this.roomType);
	}
	
	public void roomNoChanged(ValueChangeEvent e) {
		this.roomNo = e.getNewValue().toString();
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("roomNo", this.roomNo);
	}
	
	
	public List<String> showRoomTypeEjb() throws NamingException, ClassNotFoundException, SQLException {
		RoomMasterBeanRemote remote = RoomMasterHelper.lookupRemoteStatelessEmploy();
		return remote.showRoomType();
	}
	
	public List<String> showRoomNoEjb(String roomType) throws NamingException, ClassNotFoundException, SQLException{
		RoomMasterBeanRemote remote = RoomMasterHelper.lookupRemoteStatelessEmploy();
		return remote.showRoomNo(roomType);
	}
	
}
