package com.sota.net.configuration.security;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	private ObjectMapper mapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType("application/json");
		
		/*
		 * Cuando cree clase ApiError
		 * ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, authException.getMessage
		 * String strApiError = mapper.writeValueAsString(apiError)
		 * PrintWriter writer = response.getWriter
		 * writer.println(strApiError)
		 */
	}
	
	
}
