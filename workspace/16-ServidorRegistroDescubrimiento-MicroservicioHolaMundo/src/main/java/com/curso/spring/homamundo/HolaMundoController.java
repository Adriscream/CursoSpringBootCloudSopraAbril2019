package com.curso.spring.homamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

	@Autowired
	private ServicioPersona servicioPersona;
	
    @GetMapping("/")
    PersonaDto getMessage() {
        return servicioPersona.obtenerPersona();
    }
}
