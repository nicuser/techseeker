/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
