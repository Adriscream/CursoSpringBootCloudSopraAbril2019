package com.curso.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{

	@Autowired
	private MiFiltro miFiltro;
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http
 			.authorizeRequests().antMatchers("/**").hasRole("USER")
 		.and()
 			.formLogin()
 		.and()
 			.addFilterBefore(miFiltro, UsernamePasswordAuthenticationFilter.class);
 	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
 				.and().withUser("admin").password("password").roles("ADMIN", "USER");
 	}
 	
 	@Bean
 	public PasswordEncoder passwordEncoder(){
 		return NoOpPasswordEncoder.getInstance();
 	}

}
