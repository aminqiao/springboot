package com.boot.websocket;

import com.boot.websocket.domain.WiselyMessage;
import com.boot.websocket.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wuzm on 2017/12/13.
 */
@Controller
public class WsController {
    //动态发送消息时，需要用到这个对象
    public SimpMessagingTemplate template;
    @Autowired
    public WsController(SimpMessagingTemplate template) {
        this.template = template;
    }
    @MessageMapping("/welcome")
    @SendTo("/response")
    public WiselyResponse say(WiselyMessage message)throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

    @MessageMapping("/toUser")
    public void say1(WiselyMessage message)throws Exception {
        Thread.sleep(3000);
        template.convertAndSendToUser("1","/message","payload");
    }
}
