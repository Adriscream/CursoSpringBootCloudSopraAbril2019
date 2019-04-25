package com.curso.spring.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Publicador implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	//@Autowired
	//private Jackson2JsonMessageConverter jackson2JsonMessageConverter;
	
	@Override
	public void run(String... args) throws Exception {
		
		//rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
		
		//Publicador
		rabbitTemplate.convertAndSend(
				"spring-boot-exchange", 
				"spring.boot.mail", 
				new Usuario(1, "Victor"));
		
	}
}
