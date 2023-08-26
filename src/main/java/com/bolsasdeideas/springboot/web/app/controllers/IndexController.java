package com.bolsasdeideas.springboot.web.app.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsasdeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//metodos
	
	    //pasar datos a la vista
		@GetMapping({"/index", "/" , "/home"})
		public String index(Model model) {
			model.addAttribute("titulo", textoIndex);
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
			model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
			return "perfil";
		}
		
		@RequestMapping("/listar")
		public String listar(Model model) {
			
						
			model.addAttribute("titulo", textoListar);
			
			
			return "listar";
		}
		
		@ModelAttribute("usuarios")
		public List<Usuario> poblarUsuarios(){
			List<Usuario> usuarios = Arrays.asList(new Usuario("Jean", "De Horta", "jeandehorta@outlook.com"),
					new Usuario("Diego", "De Horta", "diegodehorta@outlook.com"),
					new Usuario("Danna", "De Horta", "dannadehorta@outlook.com" ),
					new Usuario("Nelis", "Sanchez", "nsanchez@outlook.com"));
			
			return usuarios;
			
		}
		
		
		
		

}
