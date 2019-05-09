package com.curso.spring.WebMvcBoot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiControllerUnitTestSpring {

	@Autowired
	private MiController sut;

	@Test
	public void comportamientoCorrectoDeHolaSinParametros() {
		String resultadoObtenido = sut.hola();

		// then

		assertEquals("Hola Mundo!", resultadoObtenido);
	}

}
