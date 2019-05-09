package com.curso.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Configuracion {

	@Bean
	public UsuarioRestController controller(){
		return new UsuarioRestController();
	}
	
}
