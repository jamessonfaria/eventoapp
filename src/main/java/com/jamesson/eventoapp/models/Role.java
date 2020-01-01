package com.jamesson.eventoapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	private String nomeRole;

	@ManyToMany
	private List<Usuario> usuarios;
	
	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
