package com.sota.net.configuration.security.jwt;

import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.sota.net.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtProvider {

	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String TOKEN_TYPE="JWT";
	
	@Value("${jwt.secret:Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus e}")
	private String jwtSecreto;
	
	@Value("${jwt.token-expiration:864000}")
	private int jwtDurationTokenEnSegundos;
	
	public String generateToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		//Duracion token
		Date tokenExpirationDate = new Date(System.currentTimeMillis() + (jwtDurationTokenEnSegundos)*1000);
		
		return Jwts.builder().signWith(Keys.hmacShaKeyFor(jwtSecreto.getBytes()), SignatureAlgorithm.HS512).
			setHeaderParam("typ", TOKEN_TYPE)
			.setSubject(Long.toString(usuario.getIdusuario()))
			.setIssuedAt(new Date())
			.setExpiration(tokenExpirationDate)
			.claim("email", usuario.getEmail())
			.claim("rol", usuario.getPerfil().getNombreperfil())
			.compact();
	}
	
	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
							.setSigningKey(Keys.hmacShaKeyFor(jwtSecreto.getBytes()))
							.parseClaimsJws(token)
							.getBody();
		
		return Long.parseLong(claims.getSubject());
	}
	
	public boolean validateToken(String authToken) {
		try {
			
			Jwts.parser().setSigningKey(jwtSecreto.getBytes()).parseClaimsJws(authToken);
			return true;
		}catch(SignatureException ex) {
			//Error en la firma del token JWT
			
		}catch(MalformedJwtException ex) {
			//Token malformado
			
		}catch(ExpiredJwtException ex) {
			//El token ha expirado
			
		}catch(UnsupportedJwtException ex) {
			//Token JWT no soportado
			
		}catch(IllegalArgumentException ex) {
			//JWT claims vacío
			
		}
		
		return false;
	}
}
