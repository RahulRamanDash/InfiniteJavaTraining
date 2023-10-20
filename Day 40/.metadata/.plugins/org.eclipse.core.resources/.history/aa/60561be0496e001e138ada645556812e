package com.java.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DoctorRemoteHelper {



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
	   public static DoctorBeanRemote lookupRemoteStatelessEmploy() throws NamingException {
		   Context ctx = createInitialContext();
	        final String distinctName = "";
	        final String beanName = "DoctorBean";
	        System.out.println(beanName);
	        final String viewClassName = DoctorBeanRemote.class.getName();
	        String appName = "";
            String moduleName = "HMSServer";
            return (DoctorBeanRemote) ctx.lookup("ejb:" 
              + appName + "/" + moduleName 
              + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	    }

}
