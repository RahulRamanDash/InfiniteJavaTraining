package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface InsuranceBeanRemote {
	List<InsuranceDetails> showInsurance();
	List<InsuranceDetails> getListOfInsurance(int firstRow, int rowCount);
	int countRows();
}
