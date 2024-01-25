package com.tci.entities;


import javax.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {
	
	@Id	
	private Long idEmpresa;
	
	private String ruc;
	
	private String razonSocial;
	
	private String direccion;
	
	private String estado;
	
	
	public Empresa() {
	
	}


	public Empresa(String ruc, String razonSocial, String direccion, String estado) {
		
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.estado = estado;
	}


	public Long getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Empresa [idEmpresa=" + idEmpresa + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", direccion="
				+ direccion + ", estado=" + estado + "]";
	}
	
	

}
