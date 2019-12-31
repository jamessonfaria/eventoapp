package com.jamesson.eventoapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jamesson.eventoapp.models.Convidado;
import com.jamesson.eventoapp.models.Evento;
import com.jamesson.eventoapp.repository.ConvidadoRepository;
import com.jamesson.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@GetMapping("/cadastrarEvento")
	public String form() {
		return "evento/formEvento";
	}
	
	@PostMapping("/cadastrarEvento")
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarEvento";
		}
		
		er.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso.");
		return "redirect:/cadastrarEvento";
	}
	
	@GetMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@GetMapping("/evento/{id}")
	public ModelAndView detalhesEvento(@PathVariable long id) {
		Evento evento = er.findById(id).orElse(new Evento());
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		
		mv.addObject("evento", evento);
		mv.addObject("convidados", convidados);
		return mv;
	}
	
	@PostMapping("/evento/{id}")
	public String detalhesEventoPost(@PathVariable long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/evento/{id}";
		}
		
		Evento evento = er.findById(id).orElse(new Evento());
		convidado.setEvento(evento);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso.");
		return "redirect:/evento/{id}";
	}
	
	@GetMapping("/deletarEvento")
	public String deletarEvento(long id) {
		Evento evento = er.findById(id).orElse(null);
		if(evento != null)
			er.delete(evento);
		
		return "redirect:/eventos";
	}
	
	@GetMapping("/deletarConvidado")
	public String deletarConvidado(String rg) {
		Convidado convidado = cr.findByRg(rg);
		cr.delete(convidado);

		Evento evento = convidado.getEvento();
		long idEvento = evento.getId();
		
		
		return "redirect:/evento/" + idEvento;
	}
	
}
