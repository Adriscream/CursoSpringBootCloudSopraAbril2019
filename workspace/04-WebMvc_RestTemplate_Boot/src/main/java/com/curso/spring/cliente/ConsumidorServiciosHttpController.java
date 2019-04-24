package com.curso.spring.cliente;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumidorServiciosHttpController {

	@Autowired
	//@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	//[GET] /cliente?id=1&nombre=Victor
	@GetMapping("/cliente")
	public String cliente(@RequestParam Long id, @RequestParam String nombre) throws RestClientException, URISyntaxException{
		
		ResponseEntity<String> resultado = restTemplate.getForEntity(
													new URI("http://localhost:8280/hola"), 
													String.class);
		
		resultado.getHeaders();
		
		resultado.getStatusCode();
		
		ResponseEntity<Usuario> resultadoPost = restTemplate.postForEntity(
												new URI("http://localhost:8280/usuario"), 
												new Usuario(id, nombre), 
												Usuario.class);
		
		
		return resultado.getBody() + resultadoPost.getBody();
	}
	
}
