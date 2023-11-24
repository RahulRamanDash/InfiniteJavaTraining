package com.java.provider;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class JsfPaginationBean {

	private static final long serialVersionUID = 1L;
	private List<PatientAppointment> cdList;
	private PatientAppointmentDaoImpl queryHelper;
	/**
	 * pagination stuff
	 */
	private int totalRows;
	static private int firstRow;
	private int rowsPerPage;
	private int totalPages;
	private int pageRange;
	private Integer[] pages;
	private int currentPage;
	/**
	 * Creates a new instance of JsfPaginationBean
	 */
	public JsfPaginationBean() {
		queryHelper = new PatientAppointmentDaoImpl();
		/**
		 * the below function should not be called in real world application
		 */
		// Set default values somehow (properties files?).
		rowsPerPage = 5; // Default rows per page (max amount of rows to be displayed at once).
		pageRange = 10; // Default page range (max amount of page links to be displayed at once).
	}
//	public List<PatientAppointment> getPatientAppointmentList() {
//		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		if (cdList == null) {
//			loadPatientAppointment();
//		}
//		return cdList;
//	}
	public List<PatientAppointment> getPatientAppointmentListNew(String searchValue, String searchMethod) throws ParseException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("searchValue", searchValue);
		sessionMap.put("searchMethod", searchMethod);
		System.out.println("Search String is  " +searchValue);
		cdList=null;
		if (cdList == null) {
			loadPatientAppointment(searchValue, searchMethod);
		}
		if(cdList.size()!=0) {		
			sessionMap.put("notFoundErr", " ");	
			return cdList;
		}else {
			sessionMap.put("notFoundErr", "Record Not Found");
			return null;
		}
//		return "ShowPatientAppointmentNew.jsp?faces-redirect=true";
	}
	public void setCdList(List<PatientAppointment> cdList) {
		this.cdList = cdList;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageRange() {
		return pageRange;
	}
	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}
	public Integer[] getPages() {
		return pages;
	}
	public void setPages(Integer[] pages) {
		this.pages = pages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private void loadPatientAppointment(String searchValue, String searchMethod) throws ParseException {
		cdList = queryHelper.searchPatientAppointmentDao(firstRow, rowsPerPage, searchValue);
		totalRows = queryHelper.countRows(searchValue);
		currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
		totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);
		pages = new Integer[pagesLength];
		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);
		for (int i = 0; i < pagesLength; i++) {
			pages[i] = ++firstPage;
		}
	}
	// -----------------------------------------------------------------------------
	public void pageFirst() throws ParseException {
		page(0);
	}
	public void pageNext() throws ParseException {
		page(firstRow + rowsPerPage);
	}
	public void pagePrevious() throws ParseException {
		page(firstRow - rowsPerPage);
	}
	public void pageLast() throws ParseException {
		page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
	}
	public void page(ActionEvent event) throws ParseException {
		page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
	}
	private void page(int firstRow) throws ParseException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		this.firstRow = firstRow;
		String searchValue = (String)sessionMap.get("searchValue");
		String searchMethod = (String)sessionMap.get("searchMethod");
		loadPatientAppointment(searchValue,searchMethod);
	}
}
