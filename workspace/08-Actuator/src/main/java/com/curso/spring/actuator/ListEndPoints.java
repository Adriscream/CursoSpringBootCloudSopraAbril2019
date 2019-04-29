package com.curso.spring.actuator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="endpoints")//Representa el path y si quisieramos configurar algo respecto a este endpoint
public class ListEndPoints {
	private List<Endpoint> endpoints;

	@Autowired
	public ListEndPoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	@ReadOperation
	public List<Endpoint> invoke() {
		return this.endpoints;
	}
}
