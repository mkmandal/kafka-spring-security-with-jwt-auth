package com.manoj.spring.cloud.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.manoj.spring.cloud.model.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	
//	@KafkaListener(topics="javaguides_json", groupId="myGroup")
//	public void consumejson(User user) {
//		
//		logger.info(String.format("Consuming Json data %s", user));
//	}

}
