package com.college.voiceapp.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageLikes {

	@Id
	@GeneratedValue
	private int messageLikesId;
	private int userId;
	private int messageId;
	private Date likedTimeStamp;
	public int getMessageLikesId() {
		return messageLikesId;
	}
	public void setMessageLikesId(int messageLikesId) {
		this.messageLikesId = messageLikesId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Date getLikedTimeStamp() {
		return likedTimeStamp;
	}
	public void setLikedTimeStamp(Date likedTimeStamp) {
		this.likedTimeStamp = likedTimeStamp;
	}
	@Override
	public String toString() {
		return "MessageLikes [messageLikesId=" + messageLikesId + ", userId=" + userId + ", messageId=" + messageId
				+ ", likedTimeStamp=" + likedTimeStamp + "]";
	}
	public MessageLikes(int userId, int messageId, Date likedTimeStamp) {
		super();
		this.userId = userId;
		this.messageId = messageId;
		this.likedTimeStamp = likedTimeStamp;
	}
	public MessageLikes() {
		super();
	}
	
	
}
