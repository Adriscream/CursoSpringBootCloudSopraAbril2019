package com.curso.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.spring.UsuarioRestController;
import com.curso.spring.entities.Usuario;
import com.curso.spring.persistence.UsuarioRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes=UsuarioRestController.class)
public class UsuarioRestControllerUnitarioTest {

	@Autowired
	private UsuarioRestController sut;
	
	//Given
	@MockBean
	private UsuarioRepository usuarioRepository;
	
	private Usuario usuario = new Usuario(0, "Victor");
	
	@Before
	public void init(){
		Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
	}
	
	@Test
	public void nuevoUsuarioCorrecto() {
		
		//Given
		Usuario resultadoEsperado = usuario;
		
		//When
		Usuario resultadoObtenido = sut.nuevoUsuario(usuario);
		
		
		//Then
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
