package com.example.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker                                                   // enable WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  // Register a websocket endpoint that the clients will use to connect to our websocket server.
  // SockJS is used to enable fallback options for browsers that don’t support websocket.
  // STOMP: Simple Text Oriented Messaging Protocol that defines the format and rules for data exchange.
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws").withSockJS();
  }

  // Configuring a message broker that will be used to route messages from one client to another.
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.setApplicationDestinationPrefixes("/app");             // should be routed to message-handling method
    registry.enableSimpleBroker("/topic");                          // should be routed to the message broker
  }

}
