package com.java.jsf;

import javax.faces.event.ValueChangeEvent;

public class RadioBean {
	private String radiovalue;
	private String radioText;
	private String gen;
	public String getRadiovalue() {
		return radiovalue;
	}
	public void setRadiovalue(String radiovalue) {
		this.radiovalue = radiovalue;
	}
	public String getRadioText() {
		return radioText;
	}
	public void setRadioText(String radioText) {
		this.radioText = radioText;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	public Gender[] getGender() {
	return Gender.values();	
	}
	
	public void radioChanged(ValueChangeEvent e) {
		this.gen = e.getNewValue().toString();
	}

}
