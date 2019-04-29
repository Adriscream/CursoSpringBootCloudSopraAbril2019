package com.curso.spring.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MiFiltro extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//Request
		
		//Custom user:password:rol1,rol2,rol3
		String header = request.getHeader("Authorization");
		
		if(header != null){
			//Este es el Principal
			UsernamePasswordAuthenticationToken authRequest 
				= extraerDeLaCabeceraLaInformacionParaGenerarElPrincipal(header);
			
			if(authRequest != null){
			
				SecurityContextHolder.getContext().setAuthentication(authRequest);
			}
		}
		
		//Responsabilidad ultima es llegar al resurso, luego indicamos que se ejecute el siguiente
		//elemento de la cadena de filtros
		filterChain.doFilter(request, response);
		
		//Response
	}

	private UsernamePasswordAuthenticationToken extraerDeLaCabeceraLaInformacionParaGenerarElPrincipal(String header) {

		String[] credentials = header.split(":");
		
		String[] rolesString = credentials[2].split(",");
		
		Collection<? extends GrantedAuthority> roles 
			= Arrays.asList(rolesString)
				.stream()
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList());
		
		UsernamePasswordAuthenticationToken authRequest 
			= new UsernamePasswordAuthenticationToken(credentials[0], credentials[1], roles);
		
		return authRequest;
	}

}
