package com.java.hms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Master")

public class PatientMaster implements Serializable{
	@Id
	@Column(name = "pid")
	private String pid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phoneNo")
	private String phoneNo;
	
	@Column(name = "disease")
	private String disease;
	
	@Column(name = "doctor_Id")
	private String doctorId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "otpString")
	private String otpString;
	
	public PatientMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientMaster(String pid, String name, int age, int weight, String gender, String address, String phoneNo,
			String disease, String doctorId, String username, String password, String email, String otpString) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.disease = disease;
		this.doctorId = doctorId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.otpString = otpString;
	}
	@Override
	public String toString() {
		return "PatientMaster [pid=" + pid + ", name=" + name + ", age=" + age + ", weight=" + weight + ", gender="
				+ gender + ", address=" + address + ", phoneNo=" + phoneNo + ", disease=" + disease + ", doctorId="
				+ doctorId + ", username=" + username + ", password=" + password + ", email=" + email + ", otpString="
				+ otpString + "]";
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtpString() {
		return otpString;
	}
	public void setOtpString(String otpString) {
		this.otpString = otpString;
	}
	
	
	
}
