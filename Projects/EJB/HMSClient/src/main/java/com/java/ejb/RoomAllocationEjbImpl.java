package com.java.ejb;

import java.sql.SQLException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class RoomAllocationEjbImpl {
	public String allocateRoomEjb(RoomAllocation room) throws NamingException, ClassNotFoundException, SQLException {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String pId = (String) sessionMap.get("patientId");
		room.setPid(pId);
		RoomAllocationBeanRemote remote = RoomAllocationHelper.lookupRemoteStatelessEmploy();
		remote.allocateRoom(room);
		return "allocationSuccess.jsp?faces-redirect=true";
	}
}
