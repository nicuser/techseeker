/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.server;

/**
 *
 * @author lsamud001c
 */
import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "edu.techseekers.training.server.HelloWorldTest")
public class HelloWorldImpl implements HelloWorldTest {
 
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
        
        @Override
	public String getHelloWorld(String name) {
		return "Webservice " + name;
	}
        
        public String getAbc() {
            return "abc";
        }
 
}
