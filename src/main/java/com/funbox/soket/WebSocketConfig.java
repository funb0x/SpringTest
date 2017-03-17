package com.funbox.soket;

import com.funbox.soket.ChatWSHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatWSHandler(), "/chat");
    }
    @Bean
    public ChatWSHandler chatWSHandler() {
        return new ChatWSHandler();
    }
}


