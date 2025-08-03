package com.substring.chat.Configuration;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer
{

    //this method is used to rout message.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        config.enableSimpleBroker("/topic");
        //topic/messages

        config.setApplicationDestinationPrefixes("/app");
        // app/chat
        // server-side: @MessagingMapping("/chat)



    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")           //Connection establishment
                .setAllowedOrigins(AppConstants.FRONT_END_BASE_URL)
                .withSockJS();
    }
}
