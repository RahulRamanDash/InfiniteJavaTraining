package com.javaday2;

public class EmployArray {

	public static void main(String[] args) {
		Employ employ1 = new Employ();
		employ1.empno = 1;
		employ1.name = "Rahul";
		employ1.basic=31500;
		
		Employ employ2 = new Employ();
		employ2.empno = 2;
		employ2.name = "Yuzi";
		employ2.basic=31500;
		
		Employ employ3 = new Employ();
		employ3.empno = 3;
		employ3.name = "Lufy";
		employ3.basic=31500;
	
		
		Employ[] arr = new Employ[] {employ1, employ2, employ3
				};
		for(Employ employ : arr){
			System.out.println(employ);
		}
	}

}
