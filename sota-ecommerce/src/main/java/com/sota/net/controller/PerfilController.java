package com.sota.net.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sota.net.entity.Perfil;
import com.sota.net.service.IPerfilService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PerfilController {
	
	private final IPerfilService perfilService;
	
	@GetMapping("/perfil")
	public List<Perfil> mostrarPerfil(){
		return perfilService.findAll();
	}
}
