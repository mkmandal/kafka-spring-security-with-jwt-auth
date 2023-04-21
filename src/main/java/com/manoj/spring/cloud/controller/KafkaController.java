package com.manoj.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.spring.cloud.kafka.JsonKafkaProducer;
import com.manoj.spring.cloud.kafka.KafkaProducer;
import com.manoj.spring.cloud.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	private KafkaProducer kafkaProducer;

	@Autowired
	public KafkaController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {

		kafkaProducer.sendMessage(message);

		return ResponseEntity.ok("Sent to the topic");

	}

	@PostMapping("/publishJsonData")
	public ResponseEntity<String> publishJson(@RequestBody User user) {

		jsonKafkaProducer.sendMessage(user);

		return ResponseEntity.ok("Json message Sent to the topic");

	}

}
