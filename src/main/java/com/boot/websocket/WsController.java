package com.boot.websocket;

import com.boot.websocket.domain.WiselyMessage;
import com.boot.websocket.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by wuzm on 2017/12/13.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message)throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }
}
