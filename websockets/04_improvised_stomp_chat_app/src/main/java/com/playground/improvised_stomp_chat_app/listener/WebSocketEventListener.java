package com.playground.improvised_stomp_chat_app.listener;

import com.playground.improvised_stomp_chat_app.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final ChatService chatService;

    @EventListener
    public void handleConnect(SessionConnectedEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) accessor.getSessionAttributes().get("username");

        if(username != null) {
            chatService.userJoined(username);
        }
    }

    @EventListener
    public void handleDisconnect(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) accessor.getSessionAttributes().get("username");

        if(username != null) {
            chatService.userLeft(username);
        }
    }
}
