package com.jamesson.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.jamesson.eventoapp.models.Convidado;
import com.jamesson.eventoapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {

	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
	
}
