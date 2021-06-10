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
			String token = getJwtFromRequest(request);
			if(StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
				Long idUsuario = tokenProvider.getUserIdFromJWT(token);
				Usuario usuario = (Usuario) UserDetailsService.loadUserById(idUsuario);
				UsernamePasswordAuthenticationToken authentication =
						new UsernamePasswordAuthenticationToken(usuario,usuario.getPerfil().getNombreperfil(), usuario.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader(tokenProvider.TOKEN_HEADER);
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(tokenProvider.TOKEN_PREFIX)) {
			return bearerToken.substring(tokenProvider.TOKEN_PREFIX.length(), bearerToken.length());
		}
		
		return null;
	}

}
