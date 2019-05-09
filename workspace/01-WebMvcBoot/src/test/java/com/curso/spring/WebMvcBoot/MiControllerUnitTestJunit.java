package com.curso.spring.WebMvcBoot;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiControllerUnitTestJunit {

	@Test
	public void holaTest() {
		
		//AAA
		
		//given
		
		MiController sut = new MiController();
		
		//Con las edpendencias, distinguimos el tipo de test a realizar
		
		//when
		
		String resultadoObtenido = sut.hola();
		
		//then
		
		assertEquals("Hola Mundo!", resultadoObtenido);
		
	}

}
