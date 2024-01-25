package com.tci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tci.entities.Empresa;
import com.tci.services.IEmpresaService;

@RestController
@RequestMapping("/api")
public class EmpresaRestController {
	
	@Autowired
	private IEmpresaService empresaService;
	
	//listar empresa
	@GetMapping("/empresas")
	public List<Empresa> listar(){
		
		return empresaService.listar();
	}
	
	
	//ingresar un registro en la tabla empresa:
	@PostMapping("/empresas")
	public Empresa ingresar(@RequestBody Empresa empresa) {
		
		return empresaService.guardar(empresa);
	}
	
	
	//listar tres ultimos registros de la tabla:
	@GetMapping("/empresas/tresultimos")
	public List<Empresa> listarTresUltimos(){
		
		return empresaService.listarTresUltimos();
	}
	

}
