package com.tibame.tga104.core.vo;

import java.io.Serializable;
import java.util.LinkedList;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;

//	private LinkedList<String> message = new LinkedList<String>();
	private String message;
	private boolean successful;
	
	public Message() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	


//	public LinkedList<String> getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message.add(message);
//	}
//	
	

	
	
	
}
