package org.sasa.group.kafka;

import lombok.extern.slf4j.Slf4j;
import org.sasa.group.helpers.ObjectUtil;
import org.sasa.group.web.rest.resource.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, MessageDto> messageKafkaTemplate;

    @Value(value = "${message.kafka.topic}")
    private String messageTopicName;

    public void sendMessage(final MessageDto message) {

        log.info("--------------------------------------------------------------------------------------");
        log.info("");
        log.info("Kafka Producer: " + ObjectUtil.javaObjectToJsonString(message));
        log.info("");
        log.info("--------------------------------------------------------------------------------------");

        messageKafkaTemplate.send(messageTopicName, message);
    }

}
