package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary d = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtWord.setText("");
    	txtResult.setText("");
    	txtWord.setDisable(false);
    	btnTranslate.setDisable(false);
    }

    @FXML
    void doTranslate(ActionEvent event) {
    		String testo = txtWord.getText();
    		testo.toLowerCase();
    		if(testo.compareTo("")==0)
    			txtResult.setText("Inserisci una parola");
    		else if(!testo.matches("[a-z? ]+")){
    			txtResult.setText("Formato errato!");
    		}
    		else if(testo.indexOf('?')!=testo.lastIndexOf('?')){
    			txtResult.setText("Troppi ?");
    		}
    		else{
    			int i = testo.lastIndexOf(" ");
            	if(i!=-1){
            		if(testo.lastIndexOf('?')>-1){
            			txtResult.setText("Errore richiesta");
            			return;
            		}
            		String alienWord = testo.substring(0, i);
            		String translation = testo.substring(i+1);
            		d.addWord(alienWord, translation);
            		txtResult.setText("Hai aggiunto la traduzione " + alienWord + " ->" + translation);
            		txtWord.setDisable(true);
            		btnTranslate.setDisable(true); 
            	}
            	else{
            		String result = d.translateWord(testo);
            		if(result==null)
            			txtResult.setText("Parola non trovata!");
            		else
            			txtResult.setText(result);
            		txtWord.setDisable(true);
            		btnTranslate.setDisable(true); 
            	}
    		} 	
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    }
    
}
