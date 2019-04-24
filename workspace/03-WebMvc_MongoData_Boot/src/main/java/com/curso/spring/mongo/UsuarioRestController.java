package com.curso.spring.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public Usuario nuevoUsuario(@RequestBody Usuario usuario){
		
		usuarioRepository.save(usuario);
		
		return usuario;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> consulta(){
		return usuarioRepository.findAll();
	}
}

