package edu.techseekers.xml.binding;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myhome
 */
public class CSVBuilder {
    public static String export(Object data) {
        Class template = data.getClass();
        System.out.println("======="+getRootTag(template.getDeclaredAnnotations()));
        Field[] fields = template.getDeclaredFields();
        Method[] operations = template.getMethods();
        Annotation[] metaData = template.getAnnotations();
        getMetadata(metaData);
        for(Field field: fields) {
            System.out.println("field name:"+field.getName());
            getMetadata(field.getAnnotations());
        }
        
        for(Method method: operations) {
            System.out.println("method name:"+method.getName());
            getMetadata(method.getAnnotations());
        }
        return "";
    }
    
    private static String getRootTag(Annotation[] metaData) {
        for(Annotation meta: metaData) {
            if(meta.annotationType().getSimpleName().equals("XmlRootElement")) {
                XmlRootElement rootElement = (XmlRootElement) meta;
                return rootElement.name();
            }
        }
        return "";
    }
    
    private static String getMetadata(Annotation[] metaData) {
        for(Annotation meta: metaData) {
            System.out.println(meta.annotationType().getName());
        }
        return "";
    }
    
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
    
    public static void main(String a[]) {
        export(getShiporder());
    }
}
