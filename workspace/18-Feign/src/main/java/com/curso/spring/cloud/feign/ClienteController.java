package com.curso.spring.cloud.feign;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
public class ClienteController {

	@Autowired
	private ServicioPersona servicioPersona;

	@RequestMapping("/")
    String getMessage() throws RestClientException, URISyntaxException {
        
		PersonaDto personaDto = servicioPersona.obtenerPersona();
    	
    	return personaDto.getNombre() + "-" + personaDto.getId();
    }
}
