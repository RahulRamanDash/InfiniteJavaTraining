package com.javaday2;

public class DynamicGetclass {

	public void show(Object obj){
		String type = obj.getClass().getSimpleName();
		System.out.println(type);
		if (type.equals("Integer")){
			int x = (Integer)obj;
			System.out.println("Integer Casting: "+x);
		}
		if (type.equals("String")){
			String x = (String)obj;
			System.out.println("String Casting: "+x);
		}
		if (type.equals("Double")){
			double x = (double)obj;
			System.out.println("Double Casting: "+x);
		}
		
	}
	public static void main(String[] args) {
		int a = 5;
		String str = "rahul";
		double fra = 17.2;
		DynamicGetclass ob =  new DynamicGetclass();
		ob.show(a);
		ob.show(str);
		ob.show(fra);
		

	}

}
