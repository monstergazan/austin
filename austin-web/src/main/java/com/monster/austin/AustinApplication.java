package com.monster.austin;

import com.monster.austin.pojo.SmsParam;
import com.monster.austin.script.TencentSmsScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
@RestController
public class AustinApplication {

    public static void main(String[] args) {
        SpringApplication.run(AustinApplication.class, args);
    }

}
