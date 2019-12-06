package com.example.websocketdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.websocketdemo.model.ChatMessage;
import com.example.websocketdemo.service.IMessageService;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {

	Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	IMessageService messageService;

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		messageService.saveMessage(chatMessage);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.getHistory")
	@SendTo("/topic/public")
	public ChatMessage getHistory(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		List<ChatMessage> history = (List<ChatMessage>) messageService.getHistroy(chatMessage);
		if (history != null) {
			logger.info(headerAccessor.getSessionAttributes().get("username") + " get History number: " + history.size());
		} else {
			logger.info(headerAccessor.getSessionAttributes().get("username") + " get History: null");
		}
		chatMessage.setHistory(history);
		return chatMessage;
	}

}
