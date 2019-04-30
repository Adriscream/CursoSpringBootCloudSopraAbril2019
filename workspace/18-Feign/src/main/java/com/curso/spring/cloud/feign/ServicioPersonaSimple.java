package com.curso.spring.cloud.feign;

public class ServicioPersonaSimple implements ServicioPersona {

	@Override
	public PersonaDto obtenerPersona() {
		return new PersonaDto(1, "Victor");
	}

}
