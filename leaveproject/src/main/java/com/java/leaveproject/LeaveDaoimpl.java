package com.java.leaveproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LeaveDaoimpl implements LeaveDAO{
	static List<LeaveDetails> leaveList;
	static{
		leaveList = new ArrayList<LeaveDetails>();
	}
	@Override
	public List<LeaveDetails> showLeaveDao() {
		return leaveList;
	}
	@Override
	public int incrimentLeaveID() {
		if(leaveList.size()==0){
			return 1;
		}
		else{
			return leaveList.get(leaveList.size()-1).getLeaveId()+1;
		}
	}
	public int countdays(LeaveDetails leavedata) {
		
		Date stDate = leavedata.getLeaveStartDate();
		Date eDate = leavedata.getLeaveEndDate();
		long diff = eDate.getTime() - stDate.getTime();
		long days = (diff/ (1000 * 60 * 60 * 24));
		days++;
		int day = (int)days;
		leavedata.setNoOfDays(day);
		return day;
	}
	
	@Override
	public String addLeaveDao(LeaveDetails leavedata) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int id = incrimentLeaveID();
		leavedata.setLeaveId(id);
		leaveList.add(leavedata);
		
		
		
		
		int count = countdays(leavedata);
		leavedata.setNoOfDays(count);
		// set applied date automaticaly
		Date date = cal.getTime();
		Date ondate = sdf.parse(sdf.format(date));
		leavedata.setLeaveAppliedOn(ondate);
		return "Leave Applied";
	}
	
	@Override
	public String writeLeaveFileDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("C:/Users/rahulr/Downloads/InfiniteJavaTraining-main/InfiniteJavaTraining-main/leaveproject/src/main/java/com/java/leaveproject/files/LeaveData.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(leaveList);
		objout.close();
		fout.close();
	
	return "***Data Stored in File***";
}

	@Override
	public String ReadLeaveFileDao() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream("C:/Users/rahulr/Downloads/InfiniteJavaTraining-main/InfiniteJavaTraining-main/leaveproject/src/main/java/com/java/leaveproject/files/LeaveData.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		leaveList = (List<LeaveDetails>) objin.readObject();
		
		objin.close();
		fin.close();
		return "Data Retracted From File";
}
//		@Override
//		public String updateLeaveDao(LeaveDetails leaveUpdated) {
//		LeaveDetails leaveFound = searchLeaveDao(leaveUpdated.getLeaveId());
//			
//			if(leaveFound != null){
//				for (LeaveDetails leave : leaveList) {
//					if(leave.getLeaveId()==leaveUpdated.getLeaveId()){
//						leave.setLeaveStatus(leaveUpdated.getLeaveStatus());
//						break;
//					}
//				}
//				return "Leave Status Record Updated";
//			}
//			
//			return "Agent Record Not Found";
//		}
	@Override
	public LeaveDetails searchLeaveDao(int leaveid) {
		LeaveDetails leaveFound = null;
		for(LeaveDetails leave : leaveList){
			if(leave.getLeaveId()==leaveid){
			leaveFound=leave;
			break;
		}
	}
		return leaveFound;
	}
	@Override
	public String ApproveDenyLeaveDao(int leaveid, String mgcomm, String leavestatus) {
			
			
				for (LeaveDetails leave : leaveList) {
					if(leave.getLeaveId()==leaveid){
						leave.setLeaveStatus(LeaveStatus.valueOf(leavestatus));
						leave.setManagerComments(mgcomm);
						break;
					}
				}
				return "Leave Status Updated";
			}


	
}
