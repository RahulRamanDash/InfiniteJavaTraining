package com.java.hib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerPolicyDaoImpl implements CustomerPolicyDAO{
	
	SessionFactory sf;
	Session session;
	
	@Override
	public String redirectToTakePolicy(int planId,double premiumAmount) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("planId", planId);
		sessionMap.put("premiumAmount", premiumAmount);
		return "takePolicy.jsp?faces-redirect=true";
	}
	
	@Override
	public String takePolicy(CustomerPolicy policyNew) throws ParseException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String custIdStr = (String) sessionMap.get("loggedCustId");
		String insuranceIdStr = (String) sessionMap.get("insuranceId");
		String planIdStr = (String) sessionMap.get("planId");
		int custId = Integer.parseInt(custIdStr);
		int insuranceId = Integer.parseInt(insuranceIdStr);
		int planId = Integer.parseInt(planIdStr);
		
		policyNew.setCustId(custId);
		policyNew.setInsuranceId(insuranceId);
		policyNew.setPlanId(planId);
		String payMode = policyNew.getPayMode().toString();
		
		double premiumAmount = (double) sessionMap.get("premiumAmount");
		System.out.println(premiumAmount);
		double insuranceAmount = calculateInsuranceAmount(premiumAmount, payMode);
		System.out.println(insuranceAmount);
		policyNew.setInsuranceAmount(insuranceAmount);
		
		double initialAmount = calculateInitialAmount(insuranceAmount);
		policyNew.setInitialAmount(initialAmount);
		
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        System.out.println("Current Date is : "+sdf.parse(formattedDate));
        policyNew.setRegisterDate(sdf.parse(formattedDate));
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(policyNew);
		transaction.commit();
		
		CustomerDetailsDaoImpl impl = new CustomerDetailsDaoImpl();
		impl.setStatusInCustomerDetails();
		
		String loggedUser = (String) sessionMap.get("loggedUser");
		CustomerDetails customerFound = impl.searchCustomer(loggedUser);
		Date regDate = sdf.parse(formattedDate);
		String email = customerFound.getEmail();
		
		sendSuccessMail(loggedUser, email, regDate);
		
		return "userDashboard.jsp?faces-redirect=true";
	}
	
	
	double calculateInsuranceAmount (double insuranceAmount, String PayMode){
		if (PayMode.equals("MONTHLY")) {
			return insuranceAmount/12;
		}else if (PayMode.equals("QUARTERLY")) {
			return insuranceAmount/4;			
		}else if (PayMode.equals("HALFYEARLY")) {
			return insuranceAmount/2;			
		}else {
			return insuranceAmount;
		}
	}
	double calculateInitialAmount (double insuranceAmount){
		double gstRate = 0.18; // 18% GST rate
		double gstAmount = insuranceAmount * gstRate;
		double initialAmount = insuranceAmount + gstAmount;
		return initialAmount;
	}
	
	public void sendSuccessMail(String username, String email, Date regDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Calendar calendar = Calendar.getInstance();
		calendar.setTime(regDate);
		calendar.add(Calendar.MONTH, 1);
		Date dueDate = calendar.getTime();
		String regDateStr = sdf.format(regDate);
		String dueDateStr = sdf.format(dueDate);
		
		
		String body = "Thank you Mr/Miss  " + username + " for taking our policy." + "\r\n" + "Your Policy has been Activated From Dt "
				+ regDateStr + "\r\n" + "Next Payment Due Date Dt " + dueDateStr;
		MailSend.mailOtp(email, "Mail Send Succesfully...", body);
	}
	
}
