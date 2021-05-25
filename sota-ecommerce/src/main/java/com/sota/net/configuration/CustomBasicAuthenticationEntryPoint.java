package com.sota.net.configuration;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

	private ObjectMapper mapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.addHeader("WWW-Authenticate", "Basic realm=\""+ getRealmName() + "\"");
		response.setContentType("application/json");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		
		/*
		 * Cuando cree apiError
		 *String apiError = mapper.writeValueAsString(apiError);
		 * PrintWriter writer = response.getWriter();
		 * writer.println(strApiError);
		 */
	}
	
	@PostConstruct
	public void initRealname() {
		setRealmName("com.sota.net");
	}
	
}
