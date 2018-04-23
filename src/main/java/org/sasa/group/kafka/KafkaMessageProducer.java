package org.sasa.group.kafka;

import org.sasa.group.web.rest.resource.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, MessageDto> messageKafkaTemplate;

    @Value(value = "${message.kafka.topic}")
    private String messageTopicName;

    public void sendMessage(final MessageDto message) {
        messageKafkaTemplate.send(messageTopicName, message);
    }

}
