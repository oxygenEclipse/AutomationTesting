package com.reviseJava;

public class ASCIICharacter {

	public static void main(String[] args) {
		char c = 'a';
		int ascii = c; // directly assign character to integer prints the ascii values
		int asciiNumber = (int) c; // using typecasting prints the ascii values

		System.out.println(ascii);
		System.out.println(asciiNumber);

	}

}
