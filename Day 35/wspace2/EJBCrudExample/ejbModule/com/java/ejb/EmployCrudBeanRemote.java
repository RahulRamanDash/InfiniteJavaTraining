package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface EmployCrudBeanRemote {
	List<Employ> showEmployDao() throws ClassNotFoundException, SQLException;
}
