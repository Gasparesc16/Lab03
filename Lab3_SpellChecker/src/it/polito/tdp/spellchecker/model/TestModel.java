package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		
		
		Dictionary d = new Dictionary();
		
		d.loadDictionary("English");
		
		List<String>inputTextList = new LinkedList<String>();
		
		inputTextList.add("ciao");
		inputTextList.add("mamma");
		inputTextList.add("hello");
		
		List<RichWord> prova = d.spellCheckText(inputTextList);
		
		for(RichWord r: prova)
			System.out.println(r);

	}

}
