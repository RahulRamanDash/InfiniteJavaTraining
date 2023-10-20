package com.java.jsf;

import java.util.Properties;

import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Calculator {


	private int firstNo;
	private int secondNo;
	private int result;
	
	public int getFirstNo() {
		return firstNo;
	}
	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}
	public int getSecondNo() {
		return secondNo;
	}
	public void setSecondNo(int secondNo) {
		this.secondNo = secondNo;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Calculator(int firstNo, int secondNo, int result) {
		this.firstNo = firstNo;
		this.secondNo = secondNo;
		this.result = result;
	}
	public Calculator() {
		
	}
	
	public void addition(ActionEvent evt) {
		
        CalculationRemote statelessRemoteCalculator = null;
		try {
			statelessRemoteCalculator = lookupRemoteStatelessCalculator();
	        this.result = statelessRemoteCalculator.sum(this.firstNo, this.secondNo);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public void substraction(ActionEvent evt) {
		
        CalculationRemote statelessRemoteCalculator = null;
		try {
			statelessRemoteCalculator = lookupRemoteStatelessCalculator();
	        this.result = statelessRemoteCalculator.sub(this.firstNo, this.secondNo);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public void multiplication(ActionEvent evt) {
		
        CalculationRemote statelessRemoteCalculator = null;
		try {
			statelessRemoteCalculator = lookupRemoteStatelessCalculator();
	        this.result = statelessRemoteCalculator.mult(this.firstNo, this.secondNo);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static Context createInitialContext() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, 
          "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.URL_PKG_PREFIXES, 
          "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.PROVIDER_URL, 
           "http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        return new InitialContext(jndiProperties);
    }
	   private static CalculationRemote lookupRemoteStatelessCalculator() throws NamingException {
		   Context ctx = createInitialContext();
	        final String distinctName = "";
	        final String beanName = "Calculation";
	        System.out.println(beanName);
	        final String viewClassName = CalculationRemote.class.getName();
	        String appName = "";
            String moduleName = "CalcServer";
            return (CalculationRemote) ctx.lookup("ejb:" 
              + appName + "/" + moduleName 
              + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	    }
}
