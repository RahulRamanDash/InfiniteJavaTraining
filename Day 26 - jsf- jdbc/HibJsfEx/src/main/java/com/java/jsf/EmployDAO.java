package com.java.jsf;

import java.util.List;

public interface EmployDAO {
	List<Employ> showEmployDao();
	String searchEmployDao(int empno);
	String addEmployDao(Employ employ);
	String updateEmployDao(Employ employUpdated);
	String deleteEmployDao(int empno);
}
