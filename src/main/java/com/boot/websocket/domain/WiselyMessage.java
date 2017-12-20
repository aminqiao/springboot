package com.boot.websocket.domain;

import lombok.Data;

/**
 * 浏览器向服务端发送的消息用此类接受
 * Created by wuzm on 2017/12/13.
 */
@Data
public class WiselyMessage {
    private String name;
    private String destinations;
    private String userId;

    public String getName() {
        return name;
    }
}
