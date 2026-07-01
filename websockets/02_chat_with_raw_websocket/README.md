# 02 - Chat Application using Raw WebSocket

## Objective

Build a multi-client chat application using Spring Boot's low-level WebSocket API without using STOMP or a message broker.

This project demonstrates how WebSocket communication works internally by manually managing client sessions and broadcasting messages.

---

## Features

- Multiple clients can connect simultaneously
- Broadcast messages to all connected clients
- Track active WebSocket sessions
- User join notifications
- User leave notifications
- Online users count
- Thread-safe session management using ConcurrentHashMap

---

## Tech Stack

- Java 21
- Spring Boot
- Spring WebSocket
- HTML
- Vanilla JavaScript

---

## Concepts Covered

- WebSocket lifecycle
- WebSocketSession
- TextWebSocketHandler
- Broadcasting
- Session management
- ConcurrentHashMap
- Thread safety
- Persistent connections

---

## Running the Project

1.

```
mvn spring-boot:run
```

2.

Open

```
http://localhost:8080
```

3.

Open another browser window.

4.

Start chatting.

---

## What I Learned

- WebSocket servers must keep track of connected clients.
- Unlike HTTP, connections remain alive until explicitly closed.
- Broadcasting requires iterating through active sessions.
- ConcurrentHashMap is required because multiple threads may access the session map simultaneously.
- Cleaning up disconnected sessions is essential to avoid memory leaks.

---

## Limitations

This project intentionally avoids STOMP.

As the application grows, manual session management becomes difficult.

The next project introduces STOMP to solve these problems using:

- Message Broker
- Topics
- Destinations
- @MessageMapping
- SimpMessagingTemplate