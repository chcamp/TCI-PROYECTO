package com.tci.services;

import java.util.List;

import com.tci.entities.Empresa;

public interface IEmpresaService {
	
	public List<Empresa> listar();
	
	public List<Empresa> listarTresUltimos();
	
	public Empresa guardar(Empresa empresa);

}
