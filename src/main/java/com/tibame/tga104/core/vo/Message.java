package com.tibame.tga104.core.vo;

import java.io.Serializable;
import java.util.LinkedList;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;

	private LinkedList<String> message = new LinkedList<String>();
	
	public Message() {
	}


	public LinkedList<String> getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message.add(message);
	}
	
	

	
	
	
}
