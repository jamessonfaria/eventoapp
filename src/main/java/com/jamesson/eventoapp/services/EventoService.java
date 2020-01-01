package com.jamesson.eventoapp.services;

import java.util.List;

import com.jamesson.eventoapp.models.Convidado;
import com.jamesson.eventoapp.models.Evento;

public interface EventoService {

	public Evento save(Evento evento);
	public List<Evento> findAll();
	public Integer findCountEvents();
	public Evento findById(Long id);
	public List<Convidado> findByEvento(Evento evento);
	public Convidado saveConvidado(Convidado convidado);
	public void delete(Evento evento);
	public Convidado findByRg(String rg);
	public void deleteConvidado(Convidado convidado);
}
