package com.jamesson.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jamesson.eventoapp.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	Evento findByNome(String nome);
	
	@Query(value = "SELECT COUNT(1) FROM evento", nativeQuery = true)
	Integer findCountEvents();
	
}
