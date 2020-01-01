package com.jamesson.eventoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamesson.eventoapp.models.Convidado;
import com.jamesson.eventoapp.models.Evento;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {

	List<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
	
}
