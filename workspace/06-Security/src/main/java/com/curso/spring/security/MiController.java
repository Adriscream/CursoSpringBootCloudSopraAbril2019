package com.curso.spring.security;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiController {

	@GetMapping(path="/hola",produces=MediaType.APPLICATION_JSON_VALUE)
	public  String hola(){
		return "Hola Mundo!";
	}
}
