package com.playground.improvised_stomp_chat_app.service;

import com.playground.improvised_stomp_chat_app.ChatEventType;
import com.playground.improvised_stomp_chat_app.dto.ChatEvent;
import com.playground.improvised_stomp_chat_app.dto.ChatMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final SimpMessagingTemplate messagingTemplate;

    @Getter
    private final List<ChatMessage> history = new CopyOnWriteArrayList<>();

    private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    public void sendMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());

        history.add(message);

        messagingTemplate.convertAndSend("/topic/messages", message);
    }

    public void isTyping(ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/typing", message);
    }

    public void publishOnlineUsers() {
        messagingTemplate.convertAndSend("/topic/users", onlineUsers);
    }

    public void userJoined(String username) {
        onlineUsers.add(username);

        messagingTemplate.convertAndSend("/topic/events",
                new ChatEvent(ChatEventType.JOIN, username, username + " joined the chat.", LocalDateTime.now()));

        publishOnlineUsers();
    }

    public void userLeft(String username) {
        onlineUsers.remove(username);

        messagingTemplate.convertAndSend("/topic/events",
                new ChatEvent(ChatEventType.LEAVE, username, username + " left the chat.", LocalDateTime.now()));

        publishOnlineUsers();
    }
}
