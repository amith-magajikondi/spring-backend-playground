package com.playground.improvised_stomp_chat_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatMessage {
    private String username;

    private String content;

    private LocalDateTime timestamp;
}
