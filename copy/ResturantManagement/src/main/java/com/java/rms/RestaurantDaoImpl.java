package com.java.rms;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class RestaurantDaoImpl implements RestaurantDAO{

	SessionFactory sf;
	Session session;

	private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public void restaurantLocaleCodeChanged(ValueChangeEvent e){
		this.localCode = e.getNewValue().toString();
	}
	
	private String menuchanged;
	
	
	public String getMenuchanged() {
		return menuchanged;
	}
	public void setMenuchanged(String menuchanged) {
		this.menuchanged = menuchanged;
	}
	public void menuChanged(ValueChangeEvent e){
		this.menuchanged = e.getNewValue().toString();
	}

//	@Override
//	public String showRestaurantsDao() {
//		Map<String, Object> sessionMap =
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		Criteria criteria = session.createCriteria(Restaurant.class);
//		List<Restaurant> restaurantsList = criteria.list();
//		sessionMap.put("restaurantsList", restaurantsList);
//		return "ShowRestaurant.jsp?faces-redirect=true";
//	}
	
	public List<String> showRestaurantNames() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Restaurant.class);
		Projection projection = Projections.property("Restaurant_Name");
		criteria.setProjection(projection);
		List<String> RestaurantNames = criteria.list();
		return RestaurantNames;
	}	
	

	
	
	
//	@Override
//	public List<Restaurant> showRestaurantsDao() {
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		Criteria criteria = session.createCriteria(Restaurant.class);
//		List<Restaurant> restaurantsList = criteria.list();
//		return restaurantsList;
//	}

}
