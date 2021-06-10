package com.sota.net.configuration.security.jwt;

import com.sota.net.entity.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String TOKEN_TYPE="JWT";
	
	@Value("${jwt.secret}")
	private String jwtSecreto;
	
	@SuppressWarnings("unused")
	public String getSecreto() {
		return jwtSecreto;
	}
	
	@Value("${jwt.token-expiration}")
	private int jwtDurationTokenEnSegundos;
	
	public String generateToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		//Duracion token
		Date tokenExpirationDate = new Date(System.currentTimeMillis() + (jwtDurationTokenEnSegundos)*100000);
		
		return Jwts.builder().signWith(Keys.hmacShaKeyFor(jwtSecreto.getBytes()), SignatureAlgorithm.HS256).
			setHeaderParam("typ", TOKEN_TYPE)
			.setIssuedAt(new Date())
			.setExpiration(tokenExpirationDate)
			.claim("sub", usuario.getIdUsuario())
			.claim("idUsuario",usuario.getIdUsuario())
			.claim("email", usuario.getEmail())
			.claim("nombre", usuario.getNombre())
			.claim("primerapellido", usuario.getPrimerapellido())
			.claim("segundoapellido", usuario.getSegundoapellido())
			.claim("perfil", usuario.getPerfil()
)
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
			System.out.println("Error en la firma del token JWT " + ex.getMessage());
			
		}catch(MalformedJwtException ex) {
			System.out.println("Token malformado " + ex.getMessage());
			
		}catch(ExpiredJwtException ex) {
			System.out.println("El token ha expirado " + ex.getMessage());
			
		}catch(UnsupportedJwtException ex) {
			System.out.println("Token JWT no soportado " + ex.getMessage());
			
		}catch(IllegalArgumentException ex) {
			System.out.println("JWT Claims vacío " + ex.getMessage());
			
		}
		
		return false;
	}
}
