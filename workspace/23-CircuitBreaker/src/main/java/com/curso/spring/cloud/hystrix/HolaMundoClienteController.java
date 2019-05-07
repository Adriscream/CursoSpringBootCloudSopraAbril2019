package com.curso.spring.cloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoClienteController {

	@Autowired
	Negocio negocio;

	@RequestMapping("/")
	public String home() {
		return negocio.home();

	}
}