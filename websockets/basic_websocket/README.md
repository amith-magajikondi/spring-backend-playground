# 01 - Basic WebSocket (Without STOMP)

## Objective

Build a minimal WebSocket server that echoes messages back to the client.

## Concepts Covered

- HTTP Upgrade Handshake
- WebSocket Endpoint
- TextWebSocketHandler
- WebSocketSession
- Connection Lifecycle

## Flow

Browser
↓
WebSocket Handshake
↓
EchoWebSocketHandler
↓
Echo Response
↓
Browser

## Key Classes

- WebSocketConfig
- EchoWebSocketHandler

## How to Run

1. Start Spring Boot
2. Open http://localhost:8080/
3. Send a message
4. Observe the echoed response

## What I Learned

- Difference between HTTP and WebSocket
- Persistent connections
- Full-duplex communication
- Sending and receiving text frames

## Next

02-chat-with-raw-websocket