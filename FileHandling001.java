/*
 * 1.	Write a Java program to store text file content line by line into an array
 */
package com.filehandling.test;

import java.io.*;
import java.util.*;

 
public class FileHandling001 {
    
	//handle exceptions by throws
    public static void main(String[] args) throws IOException {
        
    	try {
        //  creating ArrayList
        	List<String> list = new ArrayList<String>();
           
            // load data from file
            BufferedReader bf = new BufferedReader(
                new FileReader("myfile1.txt"));
           
            // read entire line as string
            String line = bf.readLine();
           
            // check end line and add line from file
            while (line != null) {
                list.add(line);
                line = bf.readLine();
            }
           
          
            bf.close();
           
            // storing the data in arraylist to array
            String[] arr = list.toArray(new String[0]);
           
            // print each line which is stored in array
            for (String str : arr) {
                System.out.println(str);
            }
        }catch(FileNotFoundException e) {	//if file not exist
        	System.out.println("file not found: " +e);
        }
    	
    }
}