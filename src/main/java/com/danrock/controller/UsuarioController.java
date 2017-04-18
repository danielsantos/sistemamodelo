package com.danrock.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danrock.model.Usuario;
import com.danrock.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/usuarios")
	public ModelAndView findAll() {
		List<Usuario> lista = service.findAll();
		
		ModelAndView modelAndView = new ModelAndView("usuarios");
		modelAndView.addObject("usuarios", lista);
		
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("/add");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(usuario);
		}
		
		service.save(usuario);
		
		return findAll();
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}	
	
}