package org.sasa.group.web.rest.impl;

import org.sasa.group.kafka.KafkaMessageProducer;
import org.sasa.group.service.MessageService;
import org.sasa.group.web.rest.resource.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @Override
    public void addMessage(final MessageDto message) {
        kafkaMessageProducer.sendMessage(message);
    }

}
