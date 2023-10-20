package com.java.ejb;

import java.sql.Date;

public class RoomAllocation {
		private String roomNo;
	    private String pid;
	    private Date admissionDate;
	    private Date releaseDate;
		public RoomAllocation() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RoomAllocation(String roomNo, String pid, Date admissionDate, Date releaseDate) {
			super();
			this.roomNo = roomNo;
			this.pid = pid;
			this.admissionDate = admissionDate;
			this.releaseDate = releaseDate;
		}
		@Override
		public String toString() {
			return "RoomAllocation [roomNo=" + roomNo + ", pid=" + pid + ", admissionDate=" + admissionDate
					+ ", releaseDate=" + releaseDate + "]";
		}
		public String getRoomNo() {
			return roomNo;
		}
		public void setRoomNo(String roomNo) {
			this.roomNo = roomNo;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public Date getAdmissionDate() {
			return admissionDate;
		}
		public void setAdmissionDate(Date admissionDate) {
			this.admissionDate = admissionDate;
		}
		public Date getReleaseDate() {
			return releaseDate;
		}
		public void setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
		}
	    
	    
}
