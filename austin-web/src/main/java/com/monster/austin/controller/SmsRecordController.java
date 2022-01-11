package com.monster.austin.controller;

import com.monster.austin.dao.SmsRecordDao;
import com.monster.austin.domain.SmsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/SmsRecord")
public class SmsRecordController {
    @Autowired
    private SmsRecordDao smsRecordDao;

    /**
     * test insert
     */
    @GetMapping("/insert")
    public String insert(Integer phone) {
        smsRecordDao.save(SmsRecord.builder().phone(Long.valueOf("13265910865")).build());
        return null;
    }

    /**
     * test query
     */
    @GetMapping("/query")
    public List<SmsRecord> query() {
        List<SmsRecord> smsRecordList =(List<SmsRecord>) smsRecordDao.findAll();
        return smsRecordList;
//        return null;
    }


}
