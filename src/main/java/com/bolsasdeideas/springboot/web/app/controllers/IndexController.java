package com.bolsasdeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

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
			usuario.setEmail("jeandehorta@outlook.com");
			
			model.addAttribute("usuario" , usuario);
			model.addAttribute("titulo", "Perfil del usuario ".concat(usuario.getNombre()));
			return "perfil";
		}
		
		@RequestMapping("/listar")
		public String listar(Model model) {
			List<Usuario> usuarios = new ArrayList<>();
			usuarios.add(new Usuario("Jean", "De Horta", "jeandehorta@outlook.com" ));
			usuarios.add(new Usuario("Diego", "De Horta", "diegodehorta@outlook.com" ));
			usuarios.add(new Usuario("Danna", "De Horta", "dannadehorta@outlook.com" ));
			usuarios.add(new Usuario("Nelis", "Sanchez", "nsanchez@outlook.com" ));
			
			model.addAttribute("titulo", "Listado de usuarios");
			model.addAttribute("usuarios" , usuarios); //arreglo
			
			return "listar";
		}
		
		

}
