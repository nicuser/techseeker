/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.xml.demo;

import edu.techseekers.xml.binding.Shiporder;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author myhome
 */
public class UnmarshalDemo {

    public static void main(String[] args) {

        try {

            File file = new File("src/main/resources/shiporder.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Shiporder.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Shiporder customer = (Shiporder) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);
            System.out.println(customer.getOrderid());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
