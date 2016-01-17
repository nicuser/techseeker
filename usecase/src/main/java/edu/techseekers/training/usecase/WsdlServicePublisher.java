/*
 * This is not the good practice to publish the service; this is only for demo purpose
 */
package edu.techseekers.training.usecase;

import edu.techseekers.training.usecase.wsdl.EmployeeServiceImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author myhome
 */
public class WsdlServicePublisher {
    public static void main(String[] args) {
        //This is not the good practice to publish the service; this is only for demo purpose
	Endpoint.publish("http://localhost:9999/ws/hello", new EmployeeServiceImpl());
    }
}
