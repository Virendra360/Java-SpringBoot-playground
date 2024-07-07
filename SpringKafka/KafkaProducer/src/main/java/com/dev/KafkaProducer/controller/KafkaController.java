package com.dev.KafkaProducer.controller;

import com.dev.KafkaProducer.service.KafkaProducerService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka-producer")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody String msg){
         kafkaProducerService.produceMsg(msg);
         return new ResponseEntity<>("Publish successfully !!", HttpStatus.OK);
    }
}
