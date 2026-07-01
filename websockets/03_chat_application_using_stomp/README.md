# 03 - Chat Application using STOMP

## Objective

Rebuild the chat application using Spring's STOMP messaging support instead of manually managing WebSocket sessions.

---

## Features

- Multi-user chat
- STOMP messaging
- Automatic broadcasting
- JSON message payloads
- Topic subscriptions
- Message routing using @MessageMapping

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

Browser

↓

STOMP Client

↓

WebSocket

↓

Spring Message Broker

↓

@MessageMapping

↓

Broker

↓

Subscribers

---

## Message Flow

Client

```
SEND /app/message
```

↓

Controller

```
@MessageMapping("/message")
```

↓

Broker

```
/topic/messages
```

↓

Subscribers

---

## Concepts Covered

- STOMP
- Message Broker
- Topics
- Application Destinations
- @MessageMapping
- @SendTo
- Automatic JSON serialization

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

- STOMP is a messaging protocol built on top of WebSocket.
- Spring automatically routes messages to controller methods.
- The Simple Broker broadcasts messages to subscribed clients.
- JSON payloads are automatically converted to Java objects.
- Controllers replace low-level WebSocket handlers.

---