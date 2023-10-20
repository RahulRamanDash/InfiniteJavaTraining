package com.java.ejb;

import javax.naming.NamingException;

public class Dummy {

	public static void main(String[] args) {
		try {
			System.out.println(RemoteHelper.lookupRemoteStatelessEmploy());
			System.out.println("JNDI Connected");
			EmployBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
			System.out.println(remote.showEmploy());
			System.out.println(new EmployEjbImpl().showEmployEjb());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
