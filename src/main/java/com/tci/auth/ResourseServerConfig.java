package com.tci.auth;


import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourseServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//dandole acceso a todos el GET de listado clientes:
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/empresas").permitAll()
		//y si hay otro uri que sea solo para usuarios autenticados.
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	

	//filtro con prioridad maximam para que permita genetrar el token y validar el token 
	//para asi acceder a los diferentes recurrsos de la aplicacion:
	/*
	@Bean
	public FilterRegistrationBean<CorsFilter> consrFilter(){
		
		FilterRegistrationBean<CorsFilter> bean = 
				new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource())); 
		
		//vamos a dar un orden bajo mientras mas bajo mayor la prioridad de precedencia
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
	}
	
	//Para implementar CORS con Spring Security	
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		
		//creamos un objeto de tipo CorsConfiguration para configurar
		CorsConfiguration config = new CorsConfiguration();
		//a partir de config, vamos a configurar nuestro CORS
		//vamos a permitir el dominio donde resode la aplicacion cliente
		//puede ser uno  varios por eso es una lista. tenemos uno nomas cliente
		//el link del front angular general:
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		//configurar todos los metodos o verbos que permitira cruzar nuestra 
		//aplicacion (get, post, put , delete):
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT","DELETE", "OPTIONS"));
		//Pemitir credenciales en true
		config.setAllowCredentials(true);
		//permitir headers o cabeceras:
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		//ahora tenemos que registrar todas nuestros endpoints del backend:
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		//la ruta para todas nuestras rutas con /** 
		source.registerCorsConfiguration("/**", config);
		
		//retornamos el source		
		return source;
	}*/
	
	

}
