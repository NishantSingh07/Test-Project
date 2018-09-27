package com.automation.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
	
   String str = "Goocgle";
   Scanner sc = new Scanner(System.in);
   
  /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   try {
	br.readLine();
} catch (IOException e) {
	e.printStackTrace();
}
   */
   System.out.println("Enter the char you want to remove");
   String s = sc.nextLine();
	  
  CharSequence c =s;
	if(str.contains(s)) {
   
 System.out.println(str.replace(c, ""));
  
	}
	}
	}

