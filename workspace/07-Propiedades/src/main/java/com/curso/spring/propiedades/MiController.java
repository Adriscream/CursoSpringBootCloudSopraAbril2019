package com.curso.spring.propiedades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiController {
	
	@Value("{spring.custom.user}")
	private String usuario;
	
	@Autowired
	private CustomProperties customProperties;
	
	@GetMapping(path="/hola",produces=MediaType.APPLICATION_JSON_VALUE)
	public  String hola(){
		return "Hola " + customProperties.getUser() + "!";
	}
	
}
