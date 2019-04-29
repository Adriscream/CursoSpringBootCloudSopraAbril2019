package com.curso.spring.propiedades;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionDaseDeDatos {

	@Bean
	public DataSource dataSource(
			@Value("{dasatource.username}") String username,
			@Value("{dasatource.password}") String password,
			@Value("{dasatource.driverclass}") String driver){
		return null;
	}
	
}
