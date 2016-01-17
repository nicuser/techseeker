/*
 * This is not the good practice to publish the service; this is only for demo purpose
 */
package edu.techseekers.training.usecase;

import edu.techseekers.training.usecase.rest.EmployeeService;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author myhome
 */
public class RestServicePublisher {

    protected RestServicePublisher() throws Exception {
        //This is not the good practice to publish the service; this is only for demo purpose
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(EmployeeService.class);
        sf.setResourceProvider(EmployeeService.class,
                new SingletonResourceProvider(new EmployeeService()));
        sf.setAddress("http://localhost:9000/");

        sf.create();
    }

    public static void main(String args[]) throws Exception {
        new RestServicePublisher();
        System.out.println("Server ready...");

        Thread.sleep(5 * 6000 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
