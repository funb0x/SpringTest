package com.funbox.soket;

import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.springframework.util.SocketUtils;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Анна on 18.03.2017.
 */
public class ChatWSHandler extends AbstractWebSocketHandler {

    private List<WebSocketSession> sessionList = new CopyOnWriteArrayList<>();

    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        sessionList.add(webSocketSession);
    }

    public void handleTextMessage(WebSocketSession webSocketSession, TextMessage message) throws Exception {
        String messagePayload = message.getPayload();
        System.out.println("received " + messagePayload);
        for(WebSocketSession session : sessionList) {
            session.sendMessage(new TextMessage(messagePayload));
        }
    }


    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        sessionList.remove(webSocketSession);
    }

}
