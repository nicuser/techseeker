/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.usecase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myhome
 */

//TODO: Closing the JDBC connection

public class DBManager {

    private Connection dbConnection;

    public DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/employees?user=root&password=dbms");
        } catch (Exception ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getDBConnection() {
        return dbConnection;
    }
}
