package com.monster.austin.controller;

import com.monster.austin.handler.SmsHandler;
import com.monster.austin.pojo.TaskInfo;
import com.monster.austin.pojo.vo.BasicResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@RestController
public class SendController {
    @Autowired
    private SmsHandler smsHandler;

    @GetMapping("/sendSms")
    public BasicResultVO<Void> sendSms(String phone, String content, Long messageTemplateId){
        TaskInfo taskInfo = TaskInfo.builder().receiver(new HashSet<>(
                    Collections.singleton(phone)))
                .content(content)
                .messageTemplateId(messageTemplateId)
                .build();
        if(smsHandler.doHandler(taskInfo)){
            return BasicResultVO.success("发送信息成功");
        }
        return BasicResultVO.fail();
    }
}
