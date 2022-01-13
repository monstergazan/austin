package com.monster.austin.kafkatest;

import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @Description 定义用户发送的日志数据
 * @Date 14:42 2018/7/20
 * @Modify By
 */
@Data
@Accessors(chain = true)
public class UserLog {
    private String username;
    private String userid;
    private String state;
}
