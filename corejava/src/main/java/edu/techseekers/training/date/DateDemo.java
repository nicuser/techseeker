/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.date;

import java.util.*;
import java.text.*;
/**
 *
 * @author myhome
 */
public class DateDemo {

    public static void main(String args[]) {

        Date dNow = new Date();
        SimpleDateFormat ft
                = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft.format(dNow));
    }
}
