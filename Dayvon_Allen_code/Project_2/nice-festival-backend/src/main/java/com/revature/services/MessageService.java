package com.revature.services;

import com.revature.exceptions.BadRequestException;
import com.revature.models.Message;
import com.revature.models.User;
import com.revature.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepo;

    @Autowired
    public MessageService(MessageRepository repo) {
        this.messageRepo = repo;
    }

    @Transactional(readOnly=true)
    public List<Message> getMessagesByReceiver() {
        return messageRepo.findAllByReceiverId(500);
    }

    @Transactional(readOnly=true)
    public List<Message> getMessagesBySender(User user) {
        if (user == null) {
            throw new BadRequestException("Invalid user information sent!");
        }
        return messageRepo.findAllBySenderId(user.getId());
    }

    @Transactional
    public void sendNewMessage(Message message) {
        messageRepo.save(message);

    }

}
