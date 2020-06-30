package org.all;

import org.english.English;

/*import org.english.English;
import org.tamil.Tamil;
import org.telugu.Telugu;*/

public class Languageclass extends English {
	public void allLanguage() {
		System.out.println("All Languages");
	}
public static void main(String[] args) {
/*	English eng = new English();
	Tamil tam = new Tamil();
	Telugu tel = new Telugu();
    eng.englishLanguage();
    tam.tamilLanguage();
    tel.teluguLanguage();   */
	Languageclass lang = new Languageclass();
	lang.teluguLanguage();
	lang.tamilLanguage();
	lang.englishLanguage();
	lang.allLanguage();
}
}
