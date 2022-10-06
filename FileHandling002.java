/*
 * 2.	Write a Java program to find the longest word in a text file.
 */
package com.filehandling.test;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileHandling002 {
	
	//handle exceptions by throws deceleration
     public static void main(String [ ] args) throws FileNotFoundException {
              new FileHandling002().findLongWord();
         }
     
   //handle exceptions by throws deceleration
     public String findLongWord() throws FileNotFoundException {

       String bigStr = "";	//biggest String variable
       String current;		//current String variable
       Scanner sc = new Scanner(new File("myfile.txt"));

       // condition to find longest word
       while (sc.hasNext()) {
          current = sc.next();
           if (current.length() > bigStr.length()) {	//compare with length()
             bigStr = current;
           }

       }
         System.out.println("Longest Word: "+bigStr+" ");	// print largest word
            return bigStr;	// return largest String
            }
}