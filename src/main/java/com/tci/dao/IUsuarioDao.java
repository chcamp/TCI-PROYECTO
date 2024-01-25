package com.tci.dao;

import org.springframework.data.repository.CrudRepository;

import com.tci.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);

}
