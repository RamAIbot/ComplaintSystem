package com.demo.complaintsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaints")
public class Complaint {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="message")
	private String message;
	
	@Column(name="sender_Name")
	private String senderName;
	
	@Column(name="sender_email")
	private String sender_email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public Complaint(String message, String senderName, String sender_email) {
		super();
		this.message = message;
		this.senderName = senderName;
		this.sender_email = sender_email;
	}

	public Complaint() {
		super();
	}
	
	
	
}
