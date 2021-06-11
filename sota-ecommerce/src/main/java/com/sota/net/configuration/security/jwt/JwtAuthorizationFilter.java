package com.sota.net.configuration.security.jwt;

import java.io.IOException;



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sota.net.entity.Usuario;
import com.sota.net.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

@Transactional
@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter{
	
	private final JwtProvider tokenProvider;
	private final CustomUserDetailsService UserDetailsService;
	
	//Funciona
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			//Metodo de abajo
			String token = getJwtFromRequest(request);
			
			//Si tiene texto y se puede validar
			if(StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
				
				//Obtenemos el id
				Long idUsuario = tokenProvider.getUserIdFromJWT(token);
				
				//Cargamos el usuario
				Usuario usuario = (Usuario) UserDetailsService.loadUserById(idUsuario);
				
				//Creamos un objeto Username.... con: el usuario, su tipo de perfil, y sus authorities
				UsernamePasswordAuthenticationToken authentication =
						new UsernamePasswordAuthenticationToken(usuario,usuario.getPerfil().getNombreperfil(), usuario.getAuthorities());
				
				//Por si hay más información
				authentication.setDetails(new WebAuthenticationDetails(request));
				
				//Guardamos el objeto autenticación en el contexto de seguridad
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
		}catch(Exception ex) {
			System.out.println("No se ha podido establecer la autenticación del usuario");
			ex.printStackTrace();
		}
		
		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		//Obtenemos el encabezado
		String bearerToken = request.getHeader(JwtProvider.TOKEN_HEADER);
		
		//Si el token -> texto + empieza por bearer= devolvemos del encabezado la parte correspondiente al token
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtProvider.TOKEN_PREFIX)) {
			return bearerToken.substring(JwtProvider.TOKEN_PREFIX.length(), bearerToken.length());
		}
		
		return null;
	}

}
