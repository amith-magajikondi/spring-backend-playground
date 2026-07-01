package com.playground.improvised_stomp_chat_app.dto;

import com.playground.improvised_stomp_chat_app.ChatEventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatEvent {
    private ChatEventType type;

    private String username;

    private String message;

    private LocalDateTime timestamp;
}
