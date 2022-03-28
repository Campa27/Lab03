package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import it.polito.tdp.spellchecker.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dizionario model;
	private int contaErrori = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label LabelErrori;

    @FXML
    private Label LabelTempo;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private TextArea txtCorrezioni;

    @FXML
    private TextArea txtParole;

    @FXML
    void handleCheck(ActionEvent event) {
    	Long start = System.nanoTime();
    	model.scegliDizionario(cmbLanguage.getValue());
    	String[] testo = txtParole.getText().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_()\\[\\]\"]", "").split(" ");
    	List<RichWord> lista = new ArrayList<RichWord>();
    	
    	for(String s : testo) {
    		RichWord nuova = new RichWord();
    		nuova.setParola(s);
    		nuova.setCorretta(model.esiste(s));
    		lista.add(nuova);
    		
    		if(nuova.isCorretta() == false) {
    			contaErrori++;
    			LabelErrori.setText(contaErrori + " errori");
    			txtCorrezioni.appendText(s);
    		}
    	}
    	Long end = System.nanoTime() - start;
    	LabelTempo.setText(end.toString());
    }

    @FXML
    void handleClear(ActionEvent event) {
    	txtParole.clear();
    	txtCorrezioni.clear();
    	LabelErrori.setText("");
    	LabelTempo.setText("");
    }

    @FXML
    void initialize() {
        assert LabelErrori != null : "fx:id=\"LabelErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert LabelTempo != null : "fx:id=\"LabelTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrezioni != null : "fx:id=\"txtCorrezioni\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbLanguage.getItems().clear();
		cmbLanguage.getItems().add("English");
		cmbLanguage.getItems().add("Italian");
        
    }

	public void setModel(Dizionario model) {
		this.model = model;
	}

}


