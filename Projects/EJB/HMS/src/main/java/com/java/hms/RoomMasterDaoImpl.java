package com.java.hms;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoomMasterDaoImpl implements RoomMasterDAO{
	
	SessionFactory sf;
	Session session;
	
	@Override
	public String showRooms() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(RoomMaster.class);
		List<RoomMaster> roomList = criteria.list();
		sessionMap.put("roomList", roomList);
		return "showRooms.jsp?faces-redirect=true";
	}

}