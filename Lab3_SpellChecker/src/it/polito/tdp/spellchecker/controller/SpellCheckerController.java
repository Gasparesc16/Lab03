/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	
	private Dictionary d;
	
	private List<String> testoDaCorreggere = new LinkedList<String>();
	
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbLanguage"
    private ComboBox<String> cmbLanguage; // Value injected by FXMLLoader

    @FXML // fx:id="txtTesto"
    private TextArea txtTesto; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtWrongWords"
    private TextArea txtWrongWords; // Value injected by FXMLLoader

    @FXML // fx:id="lbNumErrori"
    private Label lbNumErrori; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="lbTempo"
    private Label lbTempo; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	
    	this.txtTesto.clear();
    	this.txtWrongWords.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	// Gestisco la selezione della lingua
    	d.loadDictionary(this.cmbLanguage.getValue());
    	
    	
    	// Prendo il testo da correggere
    	String inputText = txtTesto.getText();
    	if (inputText.isEmpty())
    		return;
    	
    	// Divido il testo usando gli spazi
    	String array[] = this.txtTesto.getText().toLowerCase().split(" ");
    	for(String s: array)
    		testoDaCorreggere.add(s);
    	
    	// Chiamo la funzione per la correzione del testo e calcolo il tempo impiegato per la correzione
    	long to = System.nanoTime();
    	
    	List<RichWord> lista = d.spellCheckText(testoDaCorreggere);
    	
    	
    	// Stampo le parole sbagliate
    	this.txtWrongWords.appendText(lista + "\n");
    	
    	// Calcolo il numero di errori
    	
    	this.lbNumErrori.setText("The text contains " +  (lista.size() - 1) + " errors!");
    	
    	
    	
    	
    	double deT = (System.nanoTime() - to)/1e9 ;
    	
    	
    	//this.lbTempo.setText(String.format("Spell check completed in  %d seconds", deT));
    	this.lbTempo.setText(String.format("Spell check completed in " + deT + " seconds"));
    	
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtWrongWords != null : "fx:id=\"txtWrongWords\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lbNumErrori != null : "fx:id=\"lbNumErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lbTempo != null : "fx:id=\"lbTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        this.cmbLanguage.getItems().addAll(new String("Inglese"),new String("Italiano"));

    }

	public void setModel(Dictionary model) {
		d = model;
		
	}
}
