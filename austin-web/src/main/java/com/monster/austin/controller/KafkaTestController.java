//package com.monster.austin.controller;
//
//import com.monster.austin.kafkatest.UserLogProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaTestController {
//    @Autowired
//    private UserLogProducer userLogProducer;
//
//    @GetMapping("/kafka/insert")
//    public String insert(String userId){
//        userLogProducer.sendLog(userId);
//        return null;
//    }
//}
