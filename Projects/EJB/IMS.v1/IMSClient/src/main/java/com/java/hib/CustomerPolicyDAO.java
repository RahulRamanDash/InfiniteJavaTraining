package com.java.hib;

import java.text.ParseException;

public interface CustomerPolicyDAO {
	String redirectToTakePolicy(int insuranceId);
	String takePolicy(CustomerPolicy policyNew) throws ParseException;
}
