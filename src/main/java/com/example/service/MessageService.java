package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    //create new message
    public Message createNewMessage(Message message) throws Exception{
        if(message == null || message.getMessageText().isBlank()){
            throw new Exception("no message");
        }
        return messageRepository.save(message);
    }

    //get all messages
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
}
