package com.automation.main;

public class String_Opr {
	 public static void main (String[] args) {
	String str = "$^*##&! nis%&#hant @^(#NIS&#HANT&#^#0123^#7^#&";
	System.out.println(str.replaceAll("[^a-zA-Z0-9]", "").toUpperCase());
	System.out.println(str.toUpperCase());
    
}
}
