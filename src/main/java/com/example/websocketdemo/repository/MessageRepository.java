package com.example.websocketdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.websocketdemo.model.ChatMessage;

@Repository
public interface MessageRepository extends CrudRepository<ChatMessage, Long>{
}
