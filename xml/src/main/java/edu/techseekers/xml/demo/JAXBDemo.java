/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.xml.demo;

import edu.techseekers.xml.binding.Shiporder;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author myhome
 */
public class JAXBDemo {
    
    public static Shiporder getShiporder() {
        Shiporder order = new Shiporder();
        order.setOrderperson("abc");
        order.setOrderid("orderId");
        
        Shiporder.Shipto shipTo = new Shiporder.Shipto();
        shipTo.setAddress("address");
        shipTo.setCity("city");
        shipTo.setCountry("country");
        shipTo.setName("name");
        
        Shiporder.Item item = new Shiporder.Item();
        item.setNote("note");
        item.setPrice(BigDecimal.ONE);
        item.setQuantity(BigInteger.ONE);
        item.setTitle("item Title");
        
        order.setShipto(shipTo);
        order.getItem().add(item);
        
        return order;
    }
    
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Shiporder.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(getShiporder(), System.out);
    }
}
