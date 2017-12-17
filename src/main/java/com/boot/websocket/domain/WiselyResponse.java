package com.boot.websocket.domain;

import lombok.Data;

/**
 * 服务端向浏览器发送的此类的消息
 * Created by wuzm on 2017/12/13.
 */
@Data
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
