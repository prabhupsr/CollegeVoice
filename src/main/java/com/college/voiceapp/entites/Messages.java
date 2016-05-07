package com.college.voiceapp.entites;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Messages {

	@Id
	@GeneratedValue
	private int messageId;
	private String message;
	public Messages() {
		super();
	}
	private String messageUserId;
	private Date createdDate;
	private Date editedDate;
	@Override
	public String toString() {
		return "Messages [messageId=" + messageId + ", message=" + message + ", messageUserId=" + messageUserId
				+ ", createdDate=" + createdDate + ", editedDate=" + editedDate + "]";
	}
	public Messages(String message, String messageUserId, Date createdDate, Date editedDate) {
		super();
		this.message = message;
		this.messageUserId = messageUserId;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageUserId() {
		return messageUserId;
	}
	public void setMessageUserId(String messageUserId) {
		this.messageUserId = messageUserId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getEditedDate() {
		return editedDate;
	}
	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}
	
	
}
