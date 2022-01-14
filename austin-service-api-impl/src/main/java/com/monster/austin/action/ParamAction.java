package com.monster.austin.action;

import com.monster.austin.domain.SendTaskModel;
import com.monster.austin.pipline.BusinessProcess;
import com.monster.austin.pipline.ProcessContext;
/**
 * @date 2021/11/22
 * @description 参数校验
 */
public class ParamAction implements BusinessProcess {
    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
    }
}
