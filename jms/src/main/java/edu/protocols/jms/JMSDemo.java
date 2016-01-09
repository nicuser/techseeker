/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.protocols.jms;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author myhome
 */
public class JMSDemo {

    public static void main(String[] args) throws Exception {
        thread(new SimpleProducer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        Thread.sleep(1000);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        Thread.sleep(1000);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleProducer(), false);
        Thread.sleep(1000);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleConsumer(), false);
        thread(new SimpleProducer(), false);
    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }
}
