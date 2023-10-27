package com.java.hms;

import java.util.List;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class Controller {
	
	private PatientReport report;
	private PatientEjbImpl patientejbImpl;
	
	
	
	
	
	public PatientReport getReport() {
		return report;
	}

	public void setReport(PatientReport report) {
		this.report = report;
	}

	public PatientEjbImpl getPatientejbImpl() {
		return patientejbImpl;
	}

	public void setPatientejbImpl(PatientEjbImpl patientejbImpl) {
		this.patientejbImpl = patientejbImpl;
	}

	public List<PatientReport> showPatientReport() throws NamingException {
		return patientejbImpl.showPatientReportEjb();
}
	
	public String addPatientReport(PatientReport report) throws NamingException {
		if (addValid()) {
				return patientejbImpl.addPatientReportEjb(report);
		}
		return "";
	}


	
	public boolean addValid() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		String testCode = "^T.*";
		String testName = "^.{5,}$";
		
		if (!Pattern.matches(testCode, report.getTestCode())) {
			context.addMessage("form:tcode", new FacesMessage("Test Code Must Starts with a T..."));
			return false;
		}
		if (!Pattern.matches(testName, report.getTestName())){
			context.addMessage("form:tname", new FacesMessage("Test Name Contains min 5 characters..."));
			return false;
		}
		if (report.getCost()<=50) {
			context.addMessage("form:cost", new FacesMessage("Cost Must be Grater Then 50..."));
			return false;
		}
		return true;
	}
}
