package com.curso.spring.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findByNombre(String nombre);
	
	@Query("select u from Usuario u where u.nombre = ?1") //JPQL
	public List<Usuario> buscarPorNombre(String nombre);
}
