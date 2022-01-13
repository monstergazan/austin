package com.monster.austin.service;

import com.monster.austin.domain.SendRequest;
import com.monster.austin.domain.SendResponse;

/**
 * 发送接口
 *
 */
public interface SendService {
    SendResponse send(SendRequest sendRequest);
    SendResponse batchSend(SendRequest sendRequest);
}
