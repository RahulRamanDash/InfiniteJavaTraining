package com.java.hib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public String redirectToTakePolicy(int insuranceId) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("insuranceId", insuranceId);
		return "takePolicy.jsp?faces-redirect=true";
	}
	
	@Override
	public String takePolicy(CustomerPolicy policyNew) throws ParseException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String custIdStr = (String) sessionMap.get("loggedCustId");
		String insuranceIdStr = (String) sessionMap.get("insuranceId");
		int custId = Integer.parseInt(custIdStr);
		int insuranceId = Integer.parseInt(insuranceIdStr);
		policyNew.setCustId(custId);
		policyNew.setInsuranceId(insuranceId);
		String payMode = policyNew.getPayMode().toString();
		double insuranceAmount = policyNew.getInsuranceAmount();
		double initialAmount = calculateInitialAmount(insuranceAmount, payMode);
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
		
		return "userDashboard.jsp?faces-redirect=true";
	}
	

	double calculateInitialAmount(double insuranceAmount, String PayMode){
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
	
	
}
