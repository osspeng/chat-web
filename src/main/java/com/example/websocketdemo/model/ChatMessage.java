package com.example.websocketdemo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Entity
@Table(name = "message")
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private MessageType type;
	private String content;
	private String sender;
	@Transient
	private List<ChatMessage> history;

	public enum MessageType {
		CHAT, JOIN, LEAVE, HISTORY
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ChatMessage> getHistory() {
		return history;
	}

	public void setHistory(List<ChatMessage> history) {
		this.history = history;
	}
}
