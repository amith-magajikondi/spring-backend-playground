# 04 - Improvised STOMP Chat App

## Objective

A real-time chat application built using Spring Boot, WebSocket, and STOMP, demonstrating production-style messaging architecture.

---

## Features

- Multi-user chat
- STOMP messaging
- Automatic message broadcasting via broker
- JSON message payload support
- Topic-based subscriptions (/topic/messages, /topic/events, /topic/users)
- User join/leave detection
- Online users tracking in real-time
- Username captured during WebSocket handshake
- Real-time “user is typing…” updates

---

## Technologies

- Java 21
- Spring Boot
- Spring WebSocket
- STOMP
- HTML
- JavaScript
- STOMP.js

---

## Architecture

```text
Browser
   │
   ▼
STOMP Client (STOMP.js)
   │
   ▼
WebSocket Connection (/chat)
   │
   ▼
Spring Message Broker
   │
   ├── @MessageMapping Controllers
   │
   ▼
ChatService (Business Logic Layer)
   │
   ├── Online Users Store
   └── Event Processing
   │
   ▼
Broker Destinations
   │
   ├── /topic/messages
   ├── /topic/events
   ├── /topic/users
   └── /topic/typing
   │
   ▼
Subscribed Clients
```
---

## Concepts Covered

- STOMP
- Message Broker
- Topics
- Application Destinations
- @MessageMapping
- Server-side session management
- Handshake interceptors for identity injection
- Event-driven WebSocket lifecycle handling
- Real-time UI synchronization

---

## Running

```
mvn spring-boot:run
```

Open

```
http://localhost:8080
```

Open another browser window.

Start chatting.

---

## What I Learned

- STOMP simplifies WebSocket communication by introducing a broker-based model.
- Spring automatically routes messages using annotations like @MessageMapping.
- Message brokers remove the need for manual session handling.
- Server-side identity management is more secure than client-provided usernames.
- Real-time systems require careful separation of: transport layer (WebSocket), messaging layer (STOMP broker) and business logic layer (service).
- State (users, rooms, history) must be explicitly managed in backend services.
- WebSocket applications are event-driven systems, not request-response systems.

---
