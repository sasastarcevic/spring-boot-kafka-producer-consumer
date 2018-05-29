package org.sasa.group.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sasa.group.helpers.ObjectUtil;
import org.sasa.group.web.rest.resource.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "${message.kafka.topic}")
    public void messageListener(final ConsumerRecord<?, ?> consumerRecord) {

        final MessageDto message = (MessageDto) consumerRecord.value();

        log.info("####################################################################################");
        log.info("");
        log.info("Kafka Listener: " + ObjectUtil.javaObjectToJsonString(message));
        log.info("");
        log.info("####################################################################################");
    }

}