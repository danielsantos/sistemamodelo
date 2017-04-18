package com.danrock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danrock.model.Usuario;
import com.danrock.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ModelAndView listar() {
		List<Usuario> lista = repository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("usuarios");
		modelAndView.addObject("usuarios", lista);
		
		return modelAndView;
	}
	
}