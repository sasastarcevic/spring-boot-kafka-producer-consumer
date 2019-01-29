package org.sasa.group.kafka;

import lombok.extern.slf4j.Slf4j;
import org.sasa.group.helpers.ObjectUtil;
import org.sasa.group.web.rest.resource.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
public class KafkaMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, MessageDto> messageKafkaTemplate;

    @Value(value = "${message.kafka.topic}")
    private String messageTopicName;

    public void sendMessage(final MessageDto message) {

        ListenableFuture<SendResult<String, MessageDto>> future = messageKafkaTemplate.send(messageTopicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String,MessageDto>>() {

            @Override
            public void onSuccess(SendResult<String,MessageDto> result) {
                log.info("Kafka Producer: " + ObjectUtil.javaObjectToJsonString(result.getRecordMetadata()));
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });

    }

}
