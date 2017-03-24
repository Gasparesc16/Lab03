package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	private List<RichWord> paroleSbagliate;
	private List<String> dizionarioItaliano;
	private List<String> englishDictionary;
	
	
	public Dictionary() {
		
		this.paroleSbagliate = new LinkedList<RichWord>();
		this.dizionarioItaliano = new LinkedList<String>();
		this.englishDictionary = new LinkedList<String>();
		
	}
	
	
	/**
	 * Metodo che permette di caricare in memoria il dizionario della lingua desiderata
	 * 
	 * Inoltre questo metodo salva le parole del dizionario in una struttura dati appropriata
	 * 
	 * @param language
	 */

	public void loadDictionary(String language){
		
		
		if(language.compareTo("English")==0){
			
			try{
				FileReader fr = new FileReader("rsc/English.txt");
				BufferedReader br = new BufferedReader(fr);
				
				String word;
				while((word = br.readLine()) != null){
					
					englishDictionary.add(word.toLowerCase());
					
					
				}
				br.close();
				
				} catch (IOException e){
					
					System.out.println("Errore nella lettura del file");
					
				}
			
		}
		
		if(language.compareTo("Italiano")==0){
			
			try{
				FileReader fr = new FileReader("rsc/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				
				String word;
				while((word = br.readLine()) != null){
					
					// Aggiungere parola alla struttura dati
					dizionarioItaliano.add(word.toLowerCase());
					
					
				}
				br.close();
				
				
				} catch (IOException e){
					
					System.out.println("Errore nella lettura del file");
					
				}
			
		}
		
		
		
		
	}
	
	/**
	 * Metodo che esegue il controllo ortografico su testo di input (rappresentato da una lista di parole) e,
	 * restituisce una lista di RichWord.
	 * 
	 * Per ogni parola di inputTextList, tale metodo controlla se essa é presente nel dizionario.
	 * In caso affermativo, la RichWord corrispondente, che dovrà essere creata e aggiunta alla lista di ritorno,
	 * sarà corretta, altrimenti sarà errata.
	 * 
	 * @param inputTextList
	 * @return
	 */
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		RichWord r;
		
		for(String s: inputTextList){
		
			if(dizionarioItaliano.contains(s) || englishDictionary.contains(s)){
					r = new RichWord(s);
					r.setCorretta(true);
			}
			else{
				
				r = new RichWord(s);
				r.setCorretta(false);
				paroleSbagliate.add(r);
			}
				
			
			
		}
		
		return paroleSbagliate;
		
	}
	
	

}
