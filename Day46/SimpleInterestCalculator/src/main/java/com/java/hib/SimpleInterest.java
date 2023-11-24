package com.java.hib;

public class SimpleInterest {
	
	private int id;
	private double pramt;
	private double rate;
	private int period;
	private double simpleInt;
	
	
	public SimpleInterest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SimpleInterest(int id, double pramt, double rate, int period, double simpleInt) {
		super();
		this.id = id;
		this.pramt = pramt;
		this.rate = rate;
		this.period = period;
		this.simpleInt = simpleInt;
	}

	@Override
	public String toString() {
		return "SimpleInterest [id=" + id + ", pramt=" + pramt + ", rate=" + rate + ", period=" + period
				+ ", simpleInt=" + simpleInt + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPramt() {
		return pramt;
	}
	public void setPramt(double pramt) {
		this.pramt = pramt;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public double getSimpleInt() {
		return simpleInt;
	}
	public void setSimpleInt(double simpleInt) {
		this.simpleInt = simpleInt;
	}
	
	
	
}
