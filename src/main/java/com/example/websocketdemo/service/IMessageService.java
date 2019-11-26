package com.example.websocketdemo.service;

import com.example.websocketdemo.model.ChatMessage;

import java.util.List;

public interface IMessageService {

    List<ChatMessage> findAll();
    void saveMessage(ChatMessage message);
}