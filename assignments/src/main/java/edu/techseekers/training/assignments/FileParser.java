/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// more details about the assignment can be found here https://techseekers.slack.com/files/laxmikanth/F1YUXS6U8/Java_Assignment
package edu.techseekers.training.assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author myhome
 */
public class FileParser {

    public void findPattern(String word, String inputPath) throws Exception {
        String[] files = new File(inputPath).list();
        for (String f : files) {
            findOccurrence(word, inputPath + f);
        }
    }

    private void findOccurrence(String word, String filePath) throws IOException {
        File scanFile = new File(filePath);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(scanFile))) {
            String line;
            int linePosition = 1;
            while ((line = br.readLine()) != null) {
                int frequency = Collections.frequency(Arrays.asList(line.split(" ")), word);
                builder.append(filePath).append(",").append(linePosition).append(",").append(frequency).append("\n");
                linePosition++;
            }
        }
        System.out.println(builder.toString());
    }

    public static void main(String a[]) throws Exception {
        String inputPath = "/Users/myhome/bigdata/assignment/sample-data/";
        String word = "six";
        FileParser parser = new FileParser();
        parser.findPattern(word, inputPath);
    }
}
