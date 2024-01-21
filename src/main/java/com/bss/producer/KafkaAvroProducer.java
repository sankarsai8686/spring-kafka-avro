package com.bss.producer;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.bss.dto.Employee;

@Service
public class KafkaAvroProducer {
	
	@Value("${topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, Employee>	kafkaTemplate;
	
	
	public void send(Employee employee) {
		CompletableFuture<SendResult<String, Employee>> future = kafkaTemplate.send(topicName, Uuid.randomUuid().toString(), employee);
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("send message : "+result.getRecordMetadata().offset());
			} else {
				System.out.println("undable to send message due to "+ex.getMessage());
			}
		});
	}

}
