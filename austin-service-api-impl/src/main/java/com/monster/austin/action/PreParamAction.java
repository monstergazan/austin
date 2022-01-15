package com.monster.austin.action;

import cn.hutool.core.collection.CollUtil;
import com.monster.austin.domain.MessageParam;
import com.monster.austin.domain.SendTaskModel;
import com.monster.austin.enums.RespStatusEnum;
import com.monster.austin.pipline.BusinessProcess;
import com.monster.austin.pipline.ProcessContext;
import com.monster.austin.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @description 前置参数校验
 */
@Slf4j
public class PreParamAction implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();

        Long messageTemplateId = sendTaskModel.getMessageTemplateId();
        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

        if (messageTemplateId == null || CollUtil.isEmpty(messageParamList)) {
            context.setNeedBreak(true);
            context.setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
        }
    }
}
