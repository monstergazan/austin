package com.monster.austin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 发送的消息类型
 */
@AllArgsConstructor
@Getter
@ToString
public enum MessageType {
    NOTICE(10,"通知类消息"),
    MARKETING(20,"营销类消息"),
    AUTH_CODE(30,"验证码消息")
    ;

    /**
     *     `msg_type`           tinyint(4)
     *     NOT NULL DEFAULT '0' COMMENT '10.通知类消息 20.营销类消息 30.验证码类消息',
     */


    private Integer code;
    private String description;


}
