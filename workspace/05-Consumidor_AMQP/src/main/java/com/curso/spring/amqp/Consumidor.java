package com.curso.spring.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor {

	@RabbitListener(queues={"spring-boot"})
	public void procesar(String mensaje){
		System.out.println("Recibido mensaje ->" + mensaje);
	}
	
}
