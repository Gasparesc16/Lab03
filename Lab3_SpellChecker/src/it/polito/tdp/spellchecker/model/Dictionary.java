package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	private List<RichWord> paroleSbagliate;
	private List<String> dizionario;
	
	final static boolean dicotomica = false;
	
	
	
	public Dictionary() {
		
		this.paroleSbagliate = new LinkedList<RichWord>();
		this.dizionario= new LinkedList<String>();
		
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
					
					dizionario.add(word.toLowerCase());
					
					
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
					dizionario.add(word.toLowerCase());
					
					
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
	 * Per ogni parola di inputTextList, tale metodo controlla se essa � presente nel dizionario.
	 * In caso affermativo, la RichWord corrispondente, che dovr� essere creata e aggiunta alla lista di ritorno,
	 * sar� corretta, altrimenti sar� errata.
	 * 
	 * @param inputTextList
	 * @return
	 */
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		
		
		RichWord r;
		
		for(String s: inputTextList){
			
			
			if (dicotomica) {
				if (binarySearch(s.toLowerCase())){
					
					r = new RichWord(s);
					r.setCorretta(true);
				}
				else {
					
					r = new RichWord(s);
					r.setCorretta(false);
					paroleSbagliate.add(r);
				}
				
				
			} else{
				
				if(dizionario.contains(s)){
					r = new RichWord(s);
					r.setCorretta(true);
			} else{
				
				r = new RichWord(s);
				r.setCorretta(false);
				paroleSbagliate.add(r);
			}
				
			
			}
		}
		dizionario.clear();
		
		return paroleSbagliate;
		
	}


	private boolean binarySearch(String stemp) {
		
		

		int inizio = 0;
	     int fine = dizionario.size();

	     while (inizio!=fine){
	         int medio = inizio + (fine - inizio)/2;
	         if (stemp.compareToIgnoreCase(dizionario.get(medio))==0){
	             return true;
	         } else if (stemp.compareToIgnoreCase(dizionario.get(medio))>0){
	               inizio=medio +1;
	           } else {
	               fine=medio;
	           }
	     }
		
		return false;
	
	}
	
	

}
