package com.java.employ;

import java.util.List;

public class EmployBAL {
	
	static StringBuilder sb;
	static EmployDAO doa;
	static {
		sb = new StringBuilder();
		doa = new EmployDaoImpl();
	}

	public String addEmployDao(Employ employ) throws EmployException{
		if(validateEmploy(employ)==true){
			return doa.addEmployDao(employ);
		}
		throw new EmployException(sb.toString());
	}
	
	public List<Employ> showEmployBAO(){
		return doa.showEmployDao();
	}
	public boolean validateEmploy(Employ employ){
		boolean flag = true;
		
		
		if(employ.getEmpno() <= 0){
			flag = false;
			sb.append("Employ No can not be Zero or Negetive...\r\n");
		}
		if(employ.getName().length() < 5){
			flag = false;
			sb.append("Name contains min 5 cherector...\r\n");	
		}
		if(employ.getDept().length() < 5){
			flag = false;
			sb.append("Department contains min 5 cherector...\r\n");	
		}
		if(employ.getBasic() < 10000 || employ.getBasic() > 80000){
			flag = false;
			sb.append("Basic Must Be Between 10000 and 80000...\r\n");	
		}
		return flag;
	}
}
