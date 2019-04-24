package com.curso.spring.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

	public List<Usuario> findByNombre(String nombre);
	
	/*@Query("select u from Usuario u where u.nombre = ?1") //JPQL
	public List<Usuario> buscarPorNombre(String nombre);*/
}
