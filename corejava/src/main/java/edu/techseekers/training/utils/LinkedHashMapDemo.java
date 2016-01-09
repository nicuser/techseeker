/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.utils;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author lsamud001c
 */
public class LinkedHashMapDemo {

    public static void main(String a[]) {
        LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
        lhm.put("one", "This is first element");
        lhm.put("two", "This is second element");
        lhm.put("five", "This is third element");
        lhm.put("four", "Element inserted at 4th position");
        Set<String> keys = lhm.keySet();
        for (String k : keys) {
            System.out.println(k + " -- " + lhm.get(k));
        }
    }
}
