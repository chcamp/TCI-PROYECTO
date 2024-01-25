package com.tci.entities;

import java.io.Serializable;
import java.util.List;



import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String username;
	
	@Column(length = 60)
	private String password;
	
	//para habilitar o deshabilitar
	private Boolean enabled;
	
	//usuario va a tener una lista de roles
	//relacion muchos a muchos
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//customizo el nombre que se crea en la tabla intermedia:
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name="usuario_id"),
	//con joinColumns ponemos el foreingKey de los roles, receta:
	inverseJoinColumns = @JoinColumn(name="role_id"))	
	private List<Rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	

}
