package com.manoj.spring.cloud.model;

public class Message {
	
	private String message;
	private int number;
	
	public Message() {
		super();
	}

	public Message(String message,int number) {
		super();
		this.message = message;
		this.number=number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", number=" + number + "]";
	}

	
	
}
