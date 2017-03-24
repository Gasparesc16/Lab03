package it.polito.tdp.spellchecker.model;

/**
 * Classe Java Bean
 * Le convenzioni richieste sono:
 *  - La classe deve avere un costruttore senza argomenti;
 *  -  Le sue proprietà devono essere accessibili usando get, set, is (usato per i booleani al posto di get) e 
 *      altri metodi (così detti metodi accessori) seguendo una convenzione standard per i nomi;
 *  - La classe dovrebbe essere serializzabile (capace di salvare e ripristinare il suo stato in modo persistente);
 *  - Non dovrebbe contenere alcun metodo richiesto per la gestione degli eventi;
 * 
 * Ogni istanza di questa classe conterrà una parola del testo in input e l'indicazione se tale parola é corretta o meno
 * 
 * @author Gaspare
 *
 */

public class RichWord {
	
	private String word;
	private boolean corretta;

	public RichWord(String word) {
	
		this.word = word;
		this.corretta = false;
	}


	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}


	/**
	 * @return the corretta
	 */
	public boolean isCorretta() {
		return corretta;
	}


	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}


	/**
	 * @param corretta the corretta to set
	 */
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RichWord word= " + word + ", corretta=" + corretta;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	

}
