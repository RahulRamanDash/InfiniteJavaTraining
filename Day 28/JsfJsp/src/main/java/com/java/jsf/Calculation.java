package com.java.jsf;

import javax.faces.event.ActionEvent;

public class Calculation {
	private int firstno;
	private int secondno;
	private int result;
	

	public int getFirstno() {
		return firstno;
	}
	public void setFirstno(int firstno) {
		this.firstno = firstno;
	}
	public int getSecondno() {
		return secondno;
	}
	public void setSecondno(int secondno) {
		this.secondno = secondno;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public void addition(ActionEvent evt) {
		this.result = this.firstno + this.secondno;
	}
	public void substraction(ActionEvent evt) {
		this.result = this.firstno - this.secondno;
	}
	public void multiplication(ActionEvent evt) {
		this.result = this.firstno * this.secondno;
	}
}