package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

public class InsuranceEjbImpl {
	public List<InsuranceDetails> showPatientEjb() throws NamingException {
		InsuranceBeanRemote remote = InsuranceRemoteHelper.lookupRemoteStatelessEmploy();
		return remote.showInsurance();
		}
}
