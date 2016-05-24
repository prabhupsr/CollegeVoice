package com.college.voiceapp.pojo;

public class MessageWithLike {
	private Integer messageId;
	private String message;
	private Integer messageUserId;
	private Integer likedUserId;
	
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMessageUserId() {
		return messageUserId;
	}

	public void setMessageUserId(Integer messageUserId) {
		this.messageUserId = messageUserId;
	}

	public Integer getLikedUserId() {
		return likedUserId;
	}

	public void setLikedUserId(Integer likedUserId) {
		this.likedUserId = likedUserId;
	}

	@Override
	public String toString() {
		return "MessageWiithLike [messageId=" + messageId + ", message=" + message + ", messageUserId=" + messageUserId
				+ ", likedUserId=" + likedUserId + "]";
	}
	

}
