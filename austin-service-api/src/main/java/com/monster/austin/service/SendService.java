package com.monster.austin.service;

import com.monster.austin.domain.BatchSendRequest;
import com.monster.austin.domain.SendRequest;
import com.monster.austin.domain.SendResponse;

/**
 * 发送接口
 *
 */
public interface SendService {


    /**
     * 单文案发送接口
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);


    /**
     * 多文案发送接口
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);
}
