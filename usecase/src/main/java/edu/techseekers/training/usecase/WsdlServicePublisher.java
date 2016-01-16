/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
	   Endpoint.publish("http://localhost:9999/ws/hello", new EmployeeServiceImpl());
    }
}
