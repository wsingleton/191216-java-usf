package com.revature.web.controllers;

import com.revature.models.Message;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.MessageService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/send")
public class MessageSenderController {
    private MessageService messageService;
    private UserRepository userService;

    @Autowired
    public MessageSenderController(MessageService service, UserRepository userService1) {
        super();
        this.messageService = service;
        this.userService = userService1;
    }

    @PostMapping(value = "/new",produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public void sendNewMessage(@RequestBody Message newMessage) {
      newMessage.setSentTime(new Timestamp(System.currentTimeMillis()));
      newMessage.setStatus(Status.UNREAD);
      newMessage.setReceiver(500);
      messageService.sendNewMessage(newMessage);
    }

    @GetMapping(value = "/all", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getAllManagerMessages() {
        return messageService.getMessagesByReceiver();
    }

}
