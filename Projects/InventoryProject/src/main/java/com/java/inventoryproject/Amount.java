package com.java.inventoryproject;

public class Amount {
	private double Gamt;

	public Amount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amount(double gamt) {
		super();
		Gamt = gamt;
	}

	@Override
	public String toString() {
		return "Amount [Gamt=" + Gamt + "]";
	}

	public double getGamt() {
		return Gamt;
	}

	public void setGamt(double gamt) {
		Gamt = gamt;
	}

	
}
