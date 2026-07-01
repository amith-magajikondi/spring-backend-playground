package com.playground.chat_application_using_stomp.dto;

public class ChatMessage {

    private String username;

    private String content;

    public ChatMessage() {
    }

    public ChatMessage(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
