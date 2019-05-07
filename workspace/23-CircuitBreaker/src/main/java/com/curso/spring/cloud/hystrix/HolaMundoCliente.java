package com.curso.spring.cloud.hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "holamundo") // , configuration = Configuracion.class)
public interface HolaMundoCliente {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String holaMundo();
}
