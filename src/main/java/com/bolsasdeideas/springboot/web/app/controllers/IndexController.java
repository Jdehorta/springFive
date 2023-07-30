package com.bolsasdeideas.springboot.web.app.controllers;

import javax.management.AttributeValueExp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsasdeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	//metodos
	
	    //pasar datos a la vista
		@GetMapping({"/index", "/" , "/home"})
		public String index(Model model) {
			model.addAttribute("titulo", "hola spring Framework");
			return "index";
		}
		
		@RequestMapping("/perfil")
		public String perfil(Model model) {
			Usuario usuario = new Usuario();
			model.addAttribute("usuario", usuario);
			usuario.setNombre("Jean");
			usuario.setApellido("De Horta");
			
			model.addAttribute("usuario" , usuario);
			model.addAttribute("titulo", "Perfil del usuario ".concat(usuario.getNombre()));
			return "perfil";
		}

}
