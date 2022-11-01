package com.example.yuye.biz.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouliang
 * @date 2022/8/30 5:36 PM
 */
@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = {"settle_balance_record_test"})
    public void listen(String data) {
        log.info("listen req {}",data);
    }


}
