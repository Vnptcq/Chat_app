package com.chat_app.message_service.handlers;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.bson.internal.BsonUtil;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocketConnectionHandler extends TextWebSocketHandler {
    //store connection
    List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList<WebSocketSession>());

    //This method execute when client tries to connect to socket
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println(session.getId() + " established");
        webSocketSessions.add(session);
        System.out.println(webSocketSessions);
    }

    //when connection close
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        super.afterConnectionClosed(session, status);
        System.out.println(session.getId() + " closed");
        webSocketSessions.remove(session);
    }

    //handle exchange message in network
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
        System.out.println(session);
        System.out.println(webSocketSessions);
        System.out.println(message);
        //pass msg to all ignore session in list who send msg
        for (WebSocketSession webSocketSession : webSocketSessions) {
            if (webSocketSession.getId().equals(session.getId())) {
                continue;
            } else if(webSocketSession.getUri().equals(session.getUri())) {
                webSocketSession.sendMessage(message);

            }
        }
    }
}
