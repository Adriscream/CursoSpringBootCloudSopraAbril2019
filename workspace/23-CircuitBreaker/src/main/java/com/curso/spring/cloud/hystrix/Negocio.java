package com.curso.spring.cloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class Negocio {
	@Autowired
	private HolaMundoCliente holaMundoCliente;

	@HystrixCommand(
		fallbackMethod = "fallbackHome",
		commandProperties= {
			//Numero de peticiones para abrir el circuito en un tiempo definido por rollingStats
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
			//Porcentaje de error para abrir el circuito
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			//Tiempo en el que se tienen que producir las peticiones indicadas en requestVolumeThreshold
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1000"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3100")
	})
	public String home() {
		return holaMundoCliente.holaMundo() + " con Feign";
	}

	public String fallbackHome(Throwable t) {
		t.printStackTrace();
		return "Hubo un problema con un servicio: " + t.getMessage();
	}
}
