/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.client;

/**
 *
 * @author lsamud001c
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorldTest", targetNamespace = "http://webservices.concepts.edu/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorldTest {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices.concepts.edu/HelloWorldTest/getHelloWorldAsStringRequest", output = "http://webservices.concepts.edu/HelloWorldTest/getHelloWorldAsStringResponse")
    public String getHelloWorldAsString(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservices.concepts.edu/HelloWorldTest/getHelloWorldRequest", output = "http://webservices.concepts.edu/HelloWorldTest/getHelloWorldResponse")
    public String getHelloWorld(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
