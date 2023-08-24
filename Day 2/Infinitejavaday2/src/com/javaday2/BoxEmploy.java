package com.javaday2;

public class BoxEmploy {
	public void show(Object ob){
		Employ employ = (Employ)ob;
		System.out.println("Employ no: "+employ.empno+" Name: "+employ.name+" Basic: "+employ.basic);
	}

	public static void main(String[] args) {
		Employ employ = new Employ();
		employ.empno = 1033220;
		employ.name = "Rahul";
		employ.basic = 31500;

		
		BoxEmploy obj = new BoxEmploy();
		obj.show(employ);
	}

}
