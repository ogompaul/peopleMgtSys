package com.websocket.models;

public class Greeting {
	private String content;

	public Greeting(String greet) {
		this.content = greet;
	}
	public Greeting() {
		
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
