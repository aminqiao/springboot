package com.boot.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by wuzm on 2017/12/13.
 */
@Configuration
//开启使用STOMP协议来传输基于代理的消息
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个stomp的endpoint,并指定使用sockjs协议
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //这句表示在topic和user这两个域上可以向客户端发消息
        registry.enableSimpleBroker("/topic","/user");
        //这句表示给指定用户发送（一对一）的主题前缀是“/user/”
        registry.setUserDestinationPrefix("/user/");
        //这句表示客户端向服务端发送时的主题上面需要加"/app"作为前缀
        registry.setApplicationDestinationPrefixes("/app/");

    }
}
