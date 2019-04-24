package com.curso.spring.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracionWeb {

	//Objeto manejado por Spring
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
