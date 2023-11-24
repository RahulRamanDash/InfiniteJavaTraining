package com.java.hib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	public List<CustomerPolicy> showCustomerPolicy(int custId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<InsurancePlan> cdList = null;
			session.beginTransaction();
			Criteria criteria = session.createCriteria(CustomerPolicy.class);
			criteria.add(Restrictions.eqOrIsNull("custId", custId));
		return criteria.list();
	}
	
	@Override
	public String takePolicy(CustomerPolicy policyNew) throws ParseException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String insuranceIdStr = (String) sessionMap.get("insuranceId");
		String planIdStr = (String) sessionMap.get("planId");
		int insuranceId = Integer.parseInt(insuranceIdStr);
		int planId = Integer.parseInt(planIdStr);
		
		policyNew.setInsuranceId(insuranceId);
		policyNew.setPlanId(planId);
		String payMode = policyNew.getPayMode().toString();
		
		double premiumAmount = (double) sessionMap.get("premiumAmount");
		System.out.println(premiumAmount);
		double insuranceAmount = calculateInsuranceAmount(premiumAmount, payMode);
		System.out.println(insuranceAmount);
		policyNew.setInsuranceAmount(insuranceAmount);
		
		double initialAmount = calculateInitialAmount(insuranceAmount);
		sessionMap.put("initialAmount", initialAmount);
		policyNew.setInitialAmount(initialAmount);
		
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        System.out.println("Current Date is : "+sdf.parse(formattedDate));
        policyNew.setRegisterDate(sdf.parse(formattedDate));
        System.out.println("cusid is : "+policyNew.getCustId());
		System.out.println(policyNew);
        sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(policyNew);
		transaction.commit();
		
		CustomerDetailsDaoImpl impl = new CustomerDetailsDaoImpl();
		impl.setStatusInCustomerDetails();
		
		String loggedUser = (String) sessionMap.get("loggedUser");
		System.out.println(loggedUser);
		System.out.println(policyNew.getCustId());
		CustomerDetails customerFound = impl.searchCustomerById(policyNew.getCustId());
		System.out.println("Cus Found : "+customerFound);
		Date regDate = sdf.parse(formattedDate);
		String email = customerFound.getEmail();
		System.out.println(email);
		String fullName = customerFound.getFirstName()+ " " + customerFound.getLastName();
		
		sendSuccessMail(fullName, email, regDate);
		
		return "policyAddSuccess.jsp?faces-redirect=true";
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
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		Calendar calendar = Calendar.getInstance();
		calendar.setTime(regDate);
		calendar.add(Calendar.MONTH, 1);
		Date dueDate = calendar.getTime();
		String regDateStr = sdf.format(regDate);
		String dueDateStr = sdf.format(dueDate);
		
		sessionMap.put("regDateStr", regDateStr);
		sessionMap.put("dueDateStr", dueDateStr);
		String body = "Thank you Mr/Miss  " + username + " for taking our policy." + "\r\n" + "Your Policy has been Activated From Dt "
				+ regDateStr + "\r\n" + "Next Payment Due Date Dt " + dueDateStr;
		MailSend.mailOtp(email, "Mail Send Succesfully...", body);
	}
	
}
