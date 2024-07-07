//package com.dev.WebSocketDemo2.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class MyWebSocketHandler extends TextWebSocketHandler {
//
//    List<WebSocketSession> sessions= new ArrayList<>();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        sessions.add(session);
//        System.out.println("New Connection established");
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        for(WebSocketSession sessionLocal:sessions){
//            System.out.println("Received message and sending to all");
//            sessionLocal.sendMessage(new TextMessage(message.getPayload()));
//        }
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessions.remove(session);
//    }
//}
