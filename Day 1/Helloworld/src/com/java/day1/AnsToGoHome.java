package com.java.day1;

public class AnsToGoHome {
	public void calculate(int unit){
		double bill =0;
		double rate;
		if(unit<=90){
			rate=1;
			bill= rate*unit;
		}
		
		if(unit>90){
			rate=1;
			bill = rate*90;
			if(unit-90 >60){
				rate=1.5;
				bill+=(rate*60);
			}
			else{
				rate=1.5;
				bill+= rate*(unit-90);
			}
		}
			System.out.println("Bill Amount "+bill);
	}	

public static void main(String[] args) {
	int unit = 195;
	new AnsToGoHome().calculate(unit);
}

}