package com.dev.WebSocketDemo.controller;

import com.dev.WebSocketDemo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message getContent(Message message){

        System.out.println("Message received and now publishing to topic."+message);
        return  message;
    }


}
