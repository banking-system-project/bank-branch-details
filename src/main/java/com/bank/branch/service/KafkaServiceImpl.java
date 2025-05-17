package com.bank.branch.service;

import com.bank.branch.vo.BranchEventVO;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(KafkaServiceImpl.class);
    public NewTopic newTopic;

    private KafkaTemplate<String, BranchEventVO> kafkaTemplate;

    public KafkaServiceImpl(NewTopic newTopic, KafkaTemplate<String, BranchEventVO> kafkaTemplate) {
        this.newTopic = newTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BranchEventVO branchEvent){
        log.info("Sending message to topic: {}", newTopic.name());
        Message<String> message = MessageBuilder
                .withPayload(branchEvent.getMessage())
                .setHeader(KafkaHeaders.TOPIC, newTopic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
