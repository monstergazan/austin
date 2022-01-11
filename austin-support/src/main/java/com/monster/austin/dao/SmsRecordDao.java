package com.monster.austin.dao;

import com.monster.austin.domain.SmsRecord;
import org.springframework.data.repository.CrudRepository;

public interface SmsRecordDao extends CrudRepository<SmsRecord,Long> {
}
