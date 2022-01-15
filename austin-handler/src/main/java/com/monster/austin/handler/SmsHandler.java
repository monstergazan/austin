package com.monster.austin.handler;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.monster.austin.dao.SmsRecordDao;
import com.monster.austin.domain.SmsRecord;
import com.monster.austin.domain.SmsParam;
import com.monster.austin.domain.TaskInfo;
import com.monster.austin.dto.SmsContentModel;
import com.monster.austin.script.SmsScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmsHandler implements Handler{

    @Autowired
    private SmsRecordDao smsRecordDao;

    @Autowired
    private SmsScript smsScript;

    @Override
    public boolean doHandler(TaskInfo taskInfo) {
        SmsContentModel smsContentModel = (SmsContentModel) taskInfo.getContentModel();
        String resultContent;
        if(StrUtil.isNotBlank(smsContentModel.getUrl())){
            resultContent = smsContentModel.getContent() + " " + smsContentModel.getUrl();
        }else{
            resultContent = smsContentModel.getContent();
        }
        SmsParam smsParam = SmsParam.builder()
                .phones(taskInfo.getReceiver())
                .content(resultContent)
                .messageTemplateId(taskInfo.getMessageTemplateId())
                .supplierId(10)
                .supplierName("腾讯云通知类消息渠道").build();
        List<SmsRecord> recordList = smsScript.send(smsParam);

        if(CollUtil.isEmpty(recordList)){
            return false;

        }
        //将回执存进数据库
        smsRecordDao.saveAll(recordList);
        return true;
    }
}
