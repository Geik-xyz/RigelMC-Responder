package com.geik.chat.keywords;

public class defaultKeywords {
	
	
	String word;
	String message;
	//Player p;
	public defaultKeywords(String input, String wholeMessage){
		this.word = input;
		message = wholeMessage;
	}
	
	public String detected() {
		return word;
	}
	
	

}
