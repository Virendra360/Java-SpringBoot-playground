package com.dev.WebSocketDemo2.controller;

import com.dev.WebSocketDemo2.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MyController {

    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message publish(Message message){
          System.out.println("Message received now publishing to all.");
        return message;
    }
}
