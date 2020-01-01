package com.jamesson.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jamesson.eventoapp.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	public Usuario findByLogin(String login);
	
}
