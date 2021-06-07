package com.sota.net.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sota.net.entity.Perfil;
import com.sota.net.repository.IPerfilRepository;
import com.sota.net.service.IPerfilService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerfilServiceImp implements IPerfilService{
	
	private final IPerfilRepository perfilRepository;

	@Override
	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

}
