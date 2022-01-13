package com.monster.austin.kafkatest;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class UserLogConsumer {
    @KafkaListener(topics={"austin"},groupId = "austinGroup1")
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.err.println("消费消息:"+message);
        }
    }
}
