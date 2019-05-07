package com.curso.spring.consumidor;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//No necesito esta implmementacion, lo hara Feign por mi
//@Service
public class ServicioPersonaRemoto implements ServicioPersona {

	@Autowired
    private RestTemplate restTemplate;
	
	public PersonaDto obtenerPersona() {
		try {
			return restTemplate.getForEntity(new URI("http://holamundo/"), PersonaDto.class).getBody();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
