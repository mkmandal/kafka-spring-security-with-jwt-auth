package com.manoj.spring.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.spring.cloud.model.Message;

@RestController
@RequestMapping("restservice/v1")
public class HelloWorld {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello world";
	}

	@GetMapping("/message")
	public Message getMessage() {
		return new Message("Hello world",567);
	}
	
	@GetMapping("/message/pathvariable/{name}")
	public Message getMessagePathVariable(@PathVariable String name) {
		return new Message(String.format("Hello world, %s ", name),567);
	}
	
	@GetMapping("/i18n")
	public Message greeting() {
		return new Message("Hello world",567);
	}

}
