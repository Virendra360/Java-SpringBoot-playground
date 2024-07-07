package com.dev.KafkaConsumer.service;

import com.dev.KafkaConsumer.config.AppConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = AppConstants.KAFKA_TOPIC_NAME, groupId =AppConstants.GROUP_ID )
    public void subscribeMsg(MyObject myObject){
        int counter=0;
         System.out.println("Subscribe count :"+counter+ "and msg :" + myObject.toString() );
    }
}
