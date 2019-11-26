package com.example.websocketdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websocketdemo.model.ChatMessage;
import com.example.websocketdemo.repository.MessageRepository;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private MessageRepository repository;

	@Override
	public List<ChatMessage> findAll() {
		List<ChatMessage> messages = (List<ChatMessage>) repository.findAll();

		return messages;
	}

	@Override
	public void saveMessage(ChatMessage message) {
		repository.save(message);
	}
}
