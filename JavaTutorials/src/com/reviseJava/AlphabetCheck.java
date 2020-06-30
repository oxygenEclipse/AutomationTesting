package com.reviseJava;

public class AlphabetCheck {

	public static void main(String[] args) {
        char c = 'Z';
        if((c>='a' && c<='z') || (c>='A' && c<='Z'))
        	System.out.println(c +" is an Alphabet");
        else
        	System.out.println(c + " is not an Alphabet");
		
	}

}
