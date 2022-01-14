package com.monster.austin.service;

import com.monster.austin.domain.BatchSendRequest;
import com.monster.austin.domain.SendRequest;
import com.monster.austin.domain.SendResponse;
import com.monster.austin.domain.SendTaskModel;
import com.monster.austin.enums.RequestType;
import com.monster.austin.pipline.ProcessContext;
import com.monster.austin.pipline.ProcessController;
import com.monster.austin.pojo.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送接口
 * @author 3y
 */
@Service
public class SendServiceImpl implements SendService {
    @Autowired
    private ProcessController processController;

    @Override
    public SendResponse send(SendRequest sendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .requestType(RequestType.SINGLE.getCode())
                .messageParam(sendRequest.getMessageParam())
                .taskInfo(TaskInfo.builder().messageTemplateId(sendRequest.getMessageTemplateId()).build())
                .build();
        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel).build();
        ProcessContext process = processController.process(context);
        return new SendResponse(process.getResponse().getCode(),process.getResponse().getMsg());
    }

    @Override
    public SendResponse batchSend(BatchSendRequest batchSendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .requestType(RequestType.BATCH.getCode())
                .messageParamList(batchSendRequest.getMessageParamList())
                .taskInfo(TaskInfo.builder().messageTemplateId(batchSendRequest.getMessageTemplateId()).build())
                .build();
        ProcessContext context = ProcessContext.builder()
                .code(batchSendRequest.getCode())
                .processModel(sendTaskModel).build();
        ProcessContext process = processController.process(context);
        return new SendResponse(process.getResponse().getCode(),process.getResponse().getMsg());
    }
}
