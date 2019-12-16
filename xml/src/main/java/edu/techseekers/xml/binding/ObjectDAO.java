/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.xml.binding;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myhome
 */
public class ObjectDAO {

    public static TreeMap<String, String> query(Object data, TreeMap<String, String> collector, String root, List<String> context, int arrayPosition) throws Exception {

        Class template = data.getClass();
        Field[] fields = template.getDeclaredFields();
        Annotation[] templateData = template.getAnnotations();
        for (Annotation info : templateData) {
            if (root.toString().length() == 0) {
                root = getTagName(info);
            }
        }
        for (Field field : fields) {
            field.setAccessible(true);
            if (isSimpleType(field) && !isAttributeField(field)) {
                String fieldName = getFieldName(field);
                String fieldValue = getFieldValue(field, data);
                collector.put(getPath(root, context, fieldName, arrayPosition), fieldValue);
            } else if (isCollectionType(field)) {
                ArrayList<String> curContext = new ArrayList<String>();
                curContext.addAll(context);
                curContext.add(getFieldName(field));
                parseCollection(getCustomFieldValue(field, data), collector, root, curContext, getFieldName(field));
            } else if (isCustomType(field)) {
                ArrayList<String> curContext = new ArrayList<String>();
                curContext.addAll(context);
                curContext.add(getFieldName(field));
                query(getCustomFieldValue(field, data), collector, root, curContext, -1);
            } else if (isAttributeField(field)) {

            }
        }
        return collector;
    }
    
    private static String getPath(String root, List<String> contexts, String curField, int arrayPosition) {
        StringBuilder curPath = new StringBuilder(root + ".");
        for(String path: contexts) {
            curPath.append(path);
            if(arrayPosition >= 0) {
                curPath.append("[").append(arrayPosition).append("]").append(".");
            } else {
                curPath.append(".");
            }
        }
        
        curPath.append(curField);
        return curPath.toString();
    }

    private static void parseCollection(Object array, TreeMap<String, String> collector, String root, List<String> contexts, String curField) throws Exception {
        Object[] segments = ((Collection<Object>) array).toArray();
        for (int s = 0; s < segments.length; s++) {
            query(segments[s], collector, root, contexts, s);
        }
    }

    private static boolean isSimpleType(Field field) {
        String fieldType = field.getGenericType().getTypeName();
        if (fieldType.contains("String")) {
            return true;
        }
        return false;
    }

    private static boolean isCustomType(Field field) {
        if (getFieldType(field).contains("Shiporder")) {
            return true;
        }
        return false;
    }

    private static String getFieldType(Field field) {
        return field.getType().getName();
    }

    private static String getFieldValue(Field field, Object data) throws IllegalArgumentException, IllegalAccessException {
        return field.get(data).toString();
    }

    private static Object getCustomFieldValue(Field field, Object data) throws IllegalArgumentException, IllegalAccessException {
        return field.get(data);
    }

    private static String getFieldName(Field field) {
        return field.getName();
    }

    private static boolean isCollectionType(Field field) {
        return field.getType().getName().contains("List");
    }

    private static String getFieldGeneric(Field field) {
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        return genericType.getActualTypeArguments()[0].getTypeName();
    }

    private String getMetadata(Field field) {
        return "";
    }

    private String getMetadata(Class template) {
        return "";
    }

    private static String getTagName(Annotation meta) {
        String tagName = "";
        if (meta.annotationType().getSimpleName().contains("XmlRootElement")) {
            XmlRootElement rootElement = (XmlRootElement) meta;
            tagName = rootElement.name();
        } else if (meta.annotationType().getSimpleName().contains("XmlAttribute")) {
            XmlAttribute attributeElement = (XmlAttribute) meta;
            tagName = attributeElement.name();
        }
        return tagName;
    }

    private static boolean isAttributeField(Field field) {
        for (Annotation meta : field.getAnnotations()) {
            if (meta.annotationType().getSimpleName().contains("XmlAttribute")) {
                return true;
            }
        }
        return false;
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
        
        Shiporder.Item item1 = new Shiporder.Item();
        item1.setNote("note1");
        item1.setPrice(BigDecimal.TEN);
        item1.setQuantity(BigInteger.TEN);
        item1.setTitle("item1 Title");

        order.setShipto(shipTo);
        order.getItem().add(item);
        order.getItem().add(item1);

        return order;
    }

    public static void main(String a[]) throws Exception {
        TreeMap<String, String> collector = new TreeMap<String, String>();
        System.out.println(ObjectDAO.query(ObjectDAO.getShiporder(), collector, "", new ArrayList<String>(), -1));
    }
}
