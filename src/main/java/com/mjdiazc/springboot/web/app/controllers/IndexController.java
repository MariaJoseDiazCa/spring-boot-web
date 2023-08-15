package com.mjdiazc.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjdiazc.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con Model!");
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Maria Jose");
		usuario.setApellido("Diaz");
		usuario.setEmail("mjdiazca@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios: ");

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Maria Jose", "Diaz", "mjdiazca@gmail.com"),
				new Usuario("Natali", "Diaz", "nAtidiaz37@gmail.com"),
				new Usuario("Juliette", "Diaz", "julijuli@gmail.com"),
				new Usuario("Montserrat", "Robles", "monrobles@gmail.com"));
		
		return usuarios;
	}

}
