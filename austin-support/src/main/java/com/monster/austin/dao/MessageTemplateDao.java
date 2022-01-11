package com.monster.austin.dao;

import com.monster.austin.domain.MessageTemplate;
import org.springframework.data.repository.CrudRepository;

public interface MessageTemplateDao extends CrudRepository<MessageTemplate,Long> {
}
