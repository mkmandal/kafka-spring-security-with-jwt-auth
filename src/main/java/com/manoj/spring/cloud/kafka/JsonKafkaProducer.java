package com.manoj.spring.cloud.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.manoj.spring.cloud.model.User;

@Service
public class JsonKafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User user) {

		logger.info(String.format("Message sent from object %s", user));

		Message<User> msg = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "javaguides_json").build();

		kafkaTemplate.send(msg);
	}

}
