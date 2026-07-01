package com.playground.improvised_stomp_chat_app.controller;

import com.playground.improvised_stomp_chat_app.dto.ChatMessage;
import com.playground.improvised_stomp_chat_app.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/chat.join")
    public void join(@Payload ChatMessage message) {
        // This will now execute safely after the UI is fully subscribed and listening
        chatService.userJoined(message.getUsername());
    }

    @MessageMapping("/message")
    public void send(ChatMessage message) {
        chatService.sendMessage(message);
    }

    @MessageMapping("/typing")
    public void typing(ChatMessage message) {
         chatService.isTyping(message);
    }
}
