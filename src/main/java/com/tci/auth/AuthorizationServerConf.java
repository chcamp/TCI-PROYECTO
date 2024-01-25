package com.tci.auth;

import java.util.Arrays;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConf extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private InfoAdicionalToken infoAdicionalToken;
	
	
	

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		
		security.tokenKeyAccess("permitAll()")
		//solo acceden a esta ruta los clientes autenticados.
		.checkTokenAccess("isAunthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory().withClient("tciapp")
			.secret(passwordEncoder.encode("12345"))
			.scopes("read", "write")
			.authorizedGrantTypes("password", "refresh_token")
			.accessTokenValiditySeconds(3600)
			.refreshTokenValiditySeconds(3600);
			
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		//enlazando la informacion del token con el usuario
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken , accessTokenConverter()));
		
		//1.- autenticamos con el objeto authenticationManager que creamos mas arriba.
				endpoints.authenticationManager(authenticationManager)
				.tokenStore(tokenStore()) 
				//2.- vamos a crear un componente encargado de almacenar los datos de autenticacion.
				//y los claims si queremos guardar los tokens de los usuarios, 
				.accessTokenConverter(accessTokenConverter())
				//asignamos la cadena creada de tokenEnhancerChain
				.tokenEnhancer(tokenEnhancerChain);
		
	}
	
	private TokenStore tokenStore() {	
		
		return new JwtTokenStore(accessTokenConverter());
	}
	
	//este metodo retorna el token con toda la especificacion de Oauth2
	//para decodificar los datos y despues codificar los datos.
	//los datos serian el username y los roles.
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		//La key privada metemos ell rsa
		//jwtAccessTokenConverter.setSigningKey(JwtConfig. RSA_PRIVADA);
		//el que valida o verifica es la rsa puclica:
		//jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);		
		
		return jwtAccessTokenConverter;
	}
	
	
	
	

}
