package com.jamesson.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.jamesson.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {

	Evento findByNome(String nome);
	
}
