package com.dev.KafkaProducer.service;

import com.dev.KafkaProducer.config.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

class MyObject{
    private int id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return id == myObject.id && Objects.equals(msg, myObject.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msg);
    }
}

@Service
public class KafkaProducerService {

    /**
     * KafkaTemplate is used to send/produce message on topic
     * Need to pass what will be key and value type and in application.properties need to mention their serialization
     */

    // Below if value is String
//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String,MyObject> kafkaTemplate;

    /**
     *With Key: When a message has a key, Kafka uses the key to determine
     * the partition using a hash of the key.
     * This ensures that messages with the same key are sent to the same partition,
     * which can be useful for maintaining order within partitions.
     */
//    public boolean produceMsg(String key, String msg) {
//        kafkaTemplate.send(AppConstants.KAFKA_TOPIC_NAME, key, msg);
//        return true;
//    }

    /**
     * Without key : When a message has a null key, Kafka uses a round-robin approach
     * to distribute the messages across the available partitions.
     * This means that the message distribution will be evenly spread across partitions,
     * assuming an equal load.
     */

    // Below for string as value
//    public boolean produceMsg(String msg){
//        kafkaTemplate.send(AppConstants.KAFKA_TOPIC_NAME,msg);
//        return true;
//    }

    public boolean produceMsg(String msg){
        MyObject obj =new MyObject();
        obj.setId(23);
        obj.setMsg(msg);
        kafkaTemplate.send(AppConstants.KAFKA_TOPIC_NAME,obj);
        return true;
    }
}
