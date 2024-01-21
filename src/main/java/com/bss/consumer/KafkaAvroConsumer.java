package com.bss.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bss.dto.Employee;

@Service
public class KafkaAvroConsumer {
	
	
	@KafkaListener(topics = "${topic.name}")
	public void read(ConsumerRecord<String, Employee> consumerRecord) {
		System.out.println("key : "+consumerRecord.key());
		System.out.println("Employee : "+consumerRecord.value());
	}

}
