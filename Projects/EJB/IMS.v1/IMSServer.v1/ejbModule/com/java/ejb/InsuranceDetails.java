package com.java.ejb;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_details")

public class InsuranceDetails implements Serializable{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Insurance_id")
	    private int insuranceId;

	    @Column(name = "Insurance_Name", length = 255)
	    private String insuranceName;

	    @Column(name = "Type", length = 255)
	    private String type;

	    @Column(name = "PremiumStart")
	    private Date premiumStart;

	    @Column(name = "PremiumEnd")
	    private Date premiumEnd;

	    @Column(name = "MinPeriod")
	    private int minPeriod;

	    @Column(name = "MaxPeriod")
	    private int maxPeriod;

	    @Column(name = "LaunchDate")
	    private Date launchDate;

	    @Column(name = "Status", length = 10)
	    private String status;

		public InsuranceDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public InsuranceDetails(int insuranceId, String insuranceName, String type, Date premiumStart, Date premiumEnd,
				int minPeriod, int maxPeriod, Date launchDate, String status) {
			super();
			this.insuranceId = insuranceId;
			this.insuranceName = insuranceName;
			this.type = type;
			this.premiumStart = premiumStart;
			this.premiumEnd = premiumEnd;
			this.minPeriod = minPeriod;
			this.maxPeriod = maxPeriod;
			this.launchDate = launchDate;
			this.status = status;
		}

		@Override
		public String toString() {
			return "InsuranceDetails [insuranceId=" + insuranceId + ", insuranceName=" + insuranceName + ", type="
					+ type + ", premiumStart=" + premiumStart + ", premiumEnd=" + premiumEnd + ", minPeriod="
					+ minPeriod + ", maxPeriod=" + maxPeriod + ", launchDate=" + launchDate + ", status=" + status
					+ "]";
		}

		public int getInsuranceId() {
			return insuranceId;
		}

		public void setInsuranceId(int insuranceId) {
			this.insuranceId = insuranceId;
		}

		public String getInsuranceName() {
			return insuranceName;
		}

		public void setInsuranceName(String insuranceName) {
			this.insuranceName = insuranceName;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Date getPremiumStart() {
			return premiumStart;
		}

		public void setPremiumStart(Date premiumStart) {
			this.premiumStart = premiumStart;
		}

		public Date getPremiumEnd() {
			return premiumEnd;
		}

		public void setPremiumEnd(Date premiumEnd) {
			this.premiumEnd = premiumEnd;
		}

		public int getMinPeriod() {
			return minPeriod;
		}

		public void setMinPeriod(int minPeriod) {
			this.minPeriod = minPeriod;
		}

		public int getMaxPeriod() {
			return maxPeriod;
		}

		public void setMaxPeriod(int maxPeriod) {
			this.maxPeriod = maxPeriod;
		}

		public Date getLaunchDate() {
			return launchDate;
		}

		public void setLaunchDate(Date launchDate) {
			this.launchDate = launchDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
}
