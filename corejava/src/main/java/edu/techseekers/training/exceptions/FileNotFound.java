/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 *
 * @author myhome
 */
public class FileNotFound {

    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }
}
