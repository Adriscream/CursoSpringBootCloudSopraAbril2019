package com.curso.spring.propiedades;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix="spring.custom")
@Validated
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CustomProperties {
	
	@NotEmpty
	private String user;
}
