package com.tci.dao;



import org.springframework.data.domain.Pageable;	
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tci.entities.Empresa;

public interface IEmpresaDao extends JpaRepository<Empresa, Long>{
	
	@Query("SELECT e FROM Empresa e ORDER BY e.idEmpresa DESC")	
	List<Empresa> findTop3ByOrderByIdEmpresaDesc(Pageable pageable);

}
