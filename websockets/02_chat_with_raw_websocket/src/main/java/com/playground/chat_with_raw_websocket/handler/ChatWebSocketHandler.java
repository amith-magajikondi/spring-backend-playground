package com.playground.chat_with_raw_websocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final Map<String, String> usernames = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.put(session.getId(), session);
        System.out.println(session.getId() + " connected");
    }

    @Override
    public void handleTextMessage(WebSocketSession sender, TextMessage message) throws Exception {
        String payload = message.getPayload();

        if(payload.startsWith("JOIN:")) {
            String username = payload.substring(5);
            usernames.put(sender.getId(), username);
            broadcast(">>> " + username + " joined the chat.");
            broadcast("Online users: " + usernames.size());
            return;
        }

        String username = usernames.get(sender.getId());
        broadcast(username + ": " + payload);
    }

    private void broadcast(String message) throws Exception {
        TextMessage textMessage = new TextMessage(message);

        for(WebSocketSession session: sessions.values()) {
            if(session.isOpen()) {
                session.sendMessage(textMessage);
            }
        }
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());

        System.out.println(session.getId() + " disconnected");
        String username = usernames.remove(session.getId());

        if(username != null) {
            broadcast(">>> " + username + " left the chat.");
            broadcast("Online users: " + sessions.size());
        }
    }
}
