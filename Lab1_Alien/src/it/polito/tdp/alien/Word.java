package it.polito.tdp.alien;

public class Word {

	private String alienWord, translation;
	private boolean isDizionario;
		
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
		setDizionario(false);
	}
	
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public String compare(String alienWord){
		if(isDizionario)
			return translation;
		return null;
	}

	public boolean getisDizionario() {
		return isDizionario;
	}

	public void setDizionario(boolean isDizionario) {
		this.isDizionario = isDizionario;
	}
	
}
