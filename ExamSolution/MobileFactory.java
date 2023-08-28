package com.java.exam;

public class MobileFactory extends AbstractFactory {

	@Override
	public Mobile getDetails(String mobile) {
		
		if (mobile.equals("Samsung")) {
            return new Samsung();
        } else if (mobile.equals("IPhone")) {
            return new IPhone();
        } else if (mobile.equals("Oneplus")) {
            return new OnePlus();
        }
		return null;
	}

}
