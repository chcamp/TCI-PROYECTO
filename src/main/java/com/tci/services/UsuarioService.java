package com.tci.services;

import java.util.List;		
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tci.dao.IUsuarioDao;
import com.tci.entities.Usuario;



@Service
public class UsuarioService implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Vamos a obneter el usuario a traves de su username.
		Usuario usuario = usuarioDao.findByUsername(username);
		
		//si usuario es nulo , vamos a lanzar un mensaje de error
		if(usuario == null) {
			logger.error("No existe el usuario en el sistema: " + username);
			throw new UsernameNotFoundException("No existe el usuario en el sistema: " + username);
		}
		
		//aca en esta lista obtenemos los roles del usuario..
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				//para ver en consola lo el getNombre que va transformando :
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		//el metodo regresa un UserDetails y tenemos una implementacion comppleta.
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	

}
