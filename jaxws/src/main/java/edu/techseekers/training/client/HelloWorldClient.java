/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceFeature;

/**
 *
 * @author lsamud001c
 */
public class HelloWorldClient {
    
	public static void main(String[] args) throws Exception {
	HelloWorldImplService service = new HelloWorldImplService();
        HelloWorldTest test = service.getHelloWorldImplPort();
        System.out.println(test.getHelloWorldAsString("JAXWS service"));

    }
}
