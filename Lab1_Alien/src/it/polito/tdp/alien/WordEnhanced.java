package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> translations;
	private boolean isDizionario;
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		translations = new LinkedList<String>();
		isDizionario = false;
	}
	
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public String getAlienWord() {
		return alienWord;
	}
	
	public void addTranslation(String t){
		translations.add(t);
	}
	
	public String getTranslations(){
		String result = "";
		for(String s:translations)
			result += s + "\n";
		return result;
	}
	
	public boolean getisDizionario() {
		return isDizionario;
	}

	public void setDizionario(boolean isDizionario) {
		this.isDizionario = isDizionario;
	}
	
}
