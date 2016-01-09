/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.utils;

import java.util.StringTokenizer;

/**
 *
 * @author myhome
 */
public class TokenizerDemo {

    public static void main(String[] args) {

        String str = "This is String , split by StringTokenizer, created by mkyong";
        StringTokenizer st = new StringTokenizer(str);

        System.out.println("---- Split by space ------");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }

        System.out.println("---- Split by comma ',' ------");
        StringTokenizer st2 = new StringTokenizer(str, ",");

        while (st2.hasMoreElements()) {
            System.out.println(st2.nextElement());
        }
    }
}
