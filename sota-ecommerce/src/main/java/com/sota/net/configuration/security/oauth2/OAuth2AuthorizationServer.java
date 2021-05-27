package com.sota.net.configuration.security.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	
	private static final String CODE_GRANT_TYPE = "authorization_code";
	private static final String IMPLICIT_GRANT_TYPE = "implicit";
	private static final String PASS_GRANT_TYPE = "password";
	private static final String REFRESH_TOKEN_GRANT_TYPE = "refresh_token";
	
	@Value("${oauth2.id-usuario")
	private String idUsuario;
	
	@Value("${oauth2.secreto-usuario}")
	private String secretoUsuario;
	
	@Value("${oauth2.redirect-uri}")
	private String redirectUri;
	
	@Value("${oauth2.access-token-validity-seconds}")
	private int accesTokenValiditySeconds;
	
	@Value("${oauth2.refresh-token-validity-seconds}")
	private int refreshTokenValiditySeconds;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()")
		.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
			.withClient(idUsuario)
			.secret(passwordEncoder.encode(secretoUsuario))
			.authorizedGrantTypes(CODE_GRANT_TYPE, IMPLICIT_GRANT_TYPE, PASS_GRANT_TYPE, REFRESH_TOKEN_GRANT_TYPE)
			.authorities("READ_ONLY_CLIENT")
			.scopes("read")
			.resourceIds("oauth2-resources")
			.redirectUris(redirectUri)
			.accessTokenValiditySeconds(accesTokenValiditySeconds)
			.refreshTokenValiditySeconds(refreshTokenValiditySeconds);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}
	
	
	
	
}
