package com.tci.services;

import com.tci.entities.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);	
	

}
