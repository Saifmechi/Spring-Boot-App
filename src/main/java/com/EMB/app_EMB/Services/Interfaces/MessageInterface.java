package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;

import com.EMB.app_EMB.Entity.Message;

public interface MessageInterface {

	 public Message saveMessage(Message message);
	 public Message updateMessage(Long id, Message message);
	 public void deleteMessageById(Long id);
	 public Message getMessageById(Long id);
	 public List<Message> getAllMessages();
}