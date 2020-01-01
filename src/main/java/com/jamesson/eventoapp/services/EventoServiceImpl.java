package com.jamesson.eventoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesson.eventoapp.models.Convidado;
import com.jamesson.eventoapp.models.Evento;
import com.jamesson.eventoapp.repository.ConvidadoRepository;
import com.jamesson.eventoapp.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository er;
	
	@Autowired
	private ConvidadoRepository cr;

	@Override
	public Evento save(Evento evento) {
		return er.save(evento);
	}

	@Override
	public List<Evento> findAll() {
		return er.findAll();
	}

	@Override
	public Integer findCountEvents() {
		return er.findCountEvents();
	}

	@Override
	public Evento findById(Long id) {
		return er.findById(id).orElse(new Evento());
	}

	@Override
	public List<Convidado> findByEvento(Evento evento) {
		return cr.findByEvento(evento);
	}

	@Override
	public Convidado saveConvidado(Convidado convidado) {
		return cr.save(convidado);
	}

	@Override
	public void delete(Evento evento) {
		er.delete(evento);
	}

	@Override
	public Convidado findByRg(String rg) {
		return cr.findByRg(rg);
	}

	@Override
	public void deleteConvidado(Convidado convidado) {
		cr.delete(convidado);
	}
	
	
	
}
