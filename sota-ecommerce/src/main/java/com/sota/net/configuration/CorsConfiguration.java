package com.sota.net.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfiguration {

	@Bean
	public CorsFilter CorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		org.springframework.web.cors.CorsConfiguration configuracion = new org.springframework.web.cors.CorsConfiguration();
		configuracion.addAllowedOrigin("*");
		configuracion.addAllowedHeader("*");
		configuracion.addAllowedMethod("*");
		configuracion.addAllowedMethod("*");
		configuracion.addExposedHeader("*");
		source.registerCorsConfiguration("/**", configuracion);
		return new CorsFilter(source);

	}
}
