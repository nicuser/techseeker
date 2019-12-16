/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.xml.binding;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author myhome
 */
public class TestSuiteReader {
    public static void main(String a[]) throws IOException {
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> testCases = Files.readAllLines(new File("").toPath(), charset);
        for(String test: testCases) {
            String[] testFields = test.split(",");
        }
    }
}
