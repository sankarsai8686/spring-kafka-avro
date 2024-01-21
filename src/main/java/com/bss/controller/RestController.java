package com.bss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bss.dto.Employee;
import com.bss.producer.KafkaAvroProducer;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private KafkaAvroProducer avroProducer;
	
	@PostMapping("/employee")
	public String send(@RequestBody Employee employee) {
		avroProducer.send(employee);
		return "sent";
	}
	
	@GetMapping
	public String welcome() {
		return "Welcome";
	}

}
