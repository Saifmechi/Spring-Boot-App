package com.EMB.app_EMB.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Entity.Message;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Repository.MessagesRepository;
import com.EMB.app_EMB.Services.Interfaces.MessageInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessageImpl implements MessageInterface {

    @Autowired
    private MessagesRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long id, Message message) {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Message not found with id " + id));
        existingMessage.setContent(message.getContent());
        existingMessage.setSendDate();
        existingMessage.setClient(message.getClient());
        

        return messageRepository.save(existingMessage);
    }

    @Override
    public void deleteMessageById(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new RessourceNotFoundException("Message not found with id " + id);
        }
        messageRepository.deleteById(id);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Message not found with id " + id));
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}
