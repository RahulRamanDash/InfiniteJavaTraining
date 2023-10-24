package com.java.hib;

import java.io.Serializable;
import java.sql.Date;


public class InsuranceDetails implements Serializable{
	
	    private int insuranceId;
	    private String insuranceName;
	    private String type;
	    private Date premiumStart;
	    private Date premiumEnd;
	    private int minPeriod;
	    private int maxPeriod;
	    private Date launchDate;
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
