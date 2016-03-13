package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> dictionary;
	
	public AlienDictionary(){
		dictionary = new LinkedList<WordEnhanced>();
	}

	public WordEnhanced search(String a){
		for(WordEnhanced w:dictionary){
			if(w.getAlienWord().compareTo(a)==0)
				return w;
		}
		return null;
	}
	
	public void addWord(String alienWord, String translation){
		if(search(alienWord)!=null)
			search(alienWord).addTranslation(translation);
		else{
			WordEnhanced w = new WordEnhanced(alienWord);
			w.addTranslation(translation);
			dictionary.add(w);			
		}
	}
	
	public String translateWord(String alienWord){
		String r="";
		if(search(alienWord)!=null)
				return search(alienWord).getTranslations();
		else if(alienWord.lastIndexOf('?')>-1){
				for(char c='a'; c<='z'; c++){
					String nuovaParola = alienWord.replace('?', c);
					String result = translateWord(nuovaParola);
					if(result!=null)
						r += result;
				}
				return r;
			}			
		return null;
	}
	
}
