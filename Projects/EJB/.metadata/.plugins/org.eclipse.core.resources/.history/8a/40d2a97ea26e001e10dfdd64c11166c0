package com.java.ejb;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class RoomAllocationEjbImpl {
	private String roomNo;
	
	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public void roomNoChanged(ValueChangeEvent e) {
		this.roomNo = e.getNewValue().toString();
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("roomNo", this.roomNo);
	}
}
