package com.java.provider;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_appointment")

public class PatientAppointment implements Serializable{
	
    @Id
    @Column(name = "appointmentId")
    private String appointmentId;
    
    @Column(name = "providerid")
    private String providerId;
    
    @Column(name = "UHID")
    private String uhid;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "AppointmentDate")
    private Date appointmentDate;
    
    @Column(name = "AppointmentTime")
    private String appointmentTime;
    
    @Column(name = "Reason")
    private String reason;
    
    @Column(name = "Status")
    private Status status;
	
    public PatientAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientAppointment(String appointmentId, String providerId, String uhid, String firstName, String lastName,
			Date appointmentDate, String appointmentTime, String reason, Status status) {
		super();
		this.appointmentId = appointmentId;
		this.providerId = providerId;
		this.uhid = uhid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.reason = reason;
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "PatientAppointment [appointmentId=" + appointmentId + ", providerId=" + providerId + ", uhid=" + uhid
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", reason=" + reason + ", status=" + status + "]";
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getUhid() {
		return uhid;
	}

	public void setUhid(String uhid) {
		this.uhid = uhid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
}
