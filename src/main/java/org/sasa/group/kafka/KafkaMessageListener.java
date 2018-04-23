package org.sasa.group.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sasa.group.helpers.ObjectUtil;
import org.sasa.group.web.rest.resource.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "${message.kafka.topic}")
    public void messageListener(final ConsumerRecord<?, ?> consumerRecord) {
        final MessageDto message = (MessageDto) consumerRecord.value();
        LOGGER.info("####################################################################################");
        LOGGER.info("");
        LOGGER.info("Kafka Listener: " + ObjectUtil.javaObjectToJsonString(message));
        LOGGER.info("");
        LOGGER.info("####################################################################################");
    }

}