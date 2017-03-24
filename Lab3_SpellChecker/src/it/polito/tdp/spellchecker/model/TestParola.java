package it.polito.tdp.spellchecker.model;

public class TestParola {

	public static void main(String[] args) {
		
		
		RichWord rw = new RichWord("ciao");
		System.out.println(rw);
		
		RichWord rw1 = new RichWord("ciao");
		System.out.println(rw1);
		
		System.out.println(rw.equals(rw1));
		
		

	}

}
