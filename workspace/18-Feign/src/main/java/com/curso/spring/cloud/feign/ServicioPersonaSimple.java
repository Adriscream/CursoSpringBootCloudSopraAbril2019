package com.curso.spring.cloud.feign;

import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaSimple implements ServicioPersona {

	@Override
	public PersonaDto obtenerPersona() {
		return new PersonaDto(1, "Victor");
	}

}
