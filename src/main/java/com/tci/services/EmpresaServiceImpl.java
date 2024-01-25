package com.tci.services;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tci.dao.IEmpresaDao;
import com.tci.entities.Empresa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class EmpresaServiceImpl implements IEmpresaService{
	
	@Autowired
	IEmpresaDao empresaDao;

	@Override
	public List<Empresa> listar() {
		
		return empresaDao.findAll();
	}

	@Override
	public List<Empresa> listarTresUltimos() {
		
		Pageable pageable = PageRequest.of(0, 3, Sort.by("idEmpresa").descending());
		
		return empresaDao.findTop3ByOrderByIdEmpresaDesc(pageable);
	}

	@Override
	public Empresa guardar(Empresa empresa) {
		
		return empresaDao.save(empresa);
	}
	
	

}
