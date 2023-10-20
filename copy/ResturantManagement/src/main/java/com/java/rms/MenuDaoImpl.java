package com.java.rms;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class MenuDaoImpl implements MenuDAO{

	SessionFactory sf;
	Session session;
	
	private int currentPage = 0;
    private int itemsPerPage = 5;
    int restaurantId;
	
	@Override
	public String showMenuDao(int restaurantid, int pageIndex) {
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Menu.class);
		criteria.add(Restrictions.eq("restaurantid", restaurantid));
		criteria.setFirstResult(pageIndex);
	    criteria.setMaxResults(itemsPerPage);
		List<Menu> menuList = criteria.list();
		sessionMap.put("menuList", menuList);
		return "ShowMenu.jsp?faces-redirect=true";
	}

	public String showMenuDaoNew(int restaurantid) {
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Menu.class);
		criteria.add(Restrictions.eq("restaurantid", restaurantid));
		System.out.println("from method"+currentPage);
		List<Menu> menuList = criteria.list();
		sessionMap.put("menuList", menuList);
		return "ShowMenu.jsp?faces-redirect=true";
	}
	public int next() {
		return currentPage+5;
	}
	public int previous() {
		return currentPage-5;
	}
	
}
