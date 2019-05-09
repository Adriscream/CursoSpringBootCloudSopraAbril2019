package com.curso.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.spring.entities.Usuario;
import com.curso.spring.persistence.UsuarioRepository;

@RunWith(SpringRunner.class)
//Estariamos haciendo pruebas con la BD de produccion
//@SpringBootTest
@DataJpaTest
public class UsuarioRepositoryIntegrationTest {

	@Autowired
	private UsuarioRepository sut;
	
	//Lo tenemos disponible or emplear la anotacion @DataJpaTest
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void nuevoUsuarioCorrecto() {
		//Given
		Usuario usuario = new Usuario(0, "Victor");
		Usuario resultadoEsperado = usuario;
		
		//When
		Usuario resultadoObtenido = sut.save(usuario);
		
		
		//Then
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
