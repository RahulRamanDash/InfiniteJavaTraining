package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {
	String sayHello();
	String greeting(String name);

}
