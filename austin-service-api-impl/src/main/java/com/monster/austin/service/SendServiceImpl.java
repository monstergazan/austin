package com.monster.austin.service;

import com.monster.austin.domain.BatchSendRequest;
import com.monster.austin.domain.SendRequest;
import com.monster.austin.domain.SendResponse;
import com.monster.austin.domain.SendTaskModel;
import com.monster.austin.enums.RequestType;
import com.monster.austin.pipline.ProcessContext;
import com.monster.austin.pipline.ProcessController;
import com.monster.austin.domain.TaskInfo;
import com.monster.austin.vo.BasicResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .messageParamList(Arrays.asList(sendRequest.getMessageParam()))
                .build();
        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success())
                .build();
        ProcessContext process = processController.process(context);
        return new SendResponse(process.getResponse().getCode(),process.getResponse().getMsg());
    }

    @Override
    public SendResponse batchSend(BatchSendRequest batchSendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(batchSendRequest.getMessageTemplateId())
                .messageParamList(batchSendRequest.getMessageParamList())
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(batchSendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
    }
}
