package net.journeyhero.travelapp.dto;

public class Hello {
	private String message;
	private String sender;
	public Hello() {
		this.message = null;
		this.sender = null;
	}
	
	public Hello(String message, String sender) {
		this.message = message;
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
}
