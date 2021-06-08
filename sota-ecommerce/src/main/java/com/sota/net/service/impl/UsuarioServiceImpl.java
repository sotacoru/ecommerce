package com.sota.net.service.impl;

import com.sota.net.entity.Usuario;

//import com.sota.net.entity.Usuario_;
import com.sota.net.entity.dto.UsuarioBusqueda;
import com.sota.net.repository.IUsuarioRepository;
import com.sota.net.service.IUsuarioService;
import com.sota.net.utils.busqueda.UsuarioCriteria;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends QueryService implements IUsuarioService{

	
	private final IUsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly=true)
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void deleteUsuarioById(Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Transactional
	@Override
	public List<Usuario> findWithFilter(UsuarioBusqueda dto) {
		if (dto.isEmpty()) {
			return Collections.emptyList();
		}
		final Specification<Usuario> specification = this.createSpecification(UsuarioServiceImpl.createCriteria(dto));
		List<Usuario> usuarios = this.usuarioRepository.findAll(specification);
		return usuarios;
	}

	private Specification<Usuario> createSpecification(UsuarioCriteria criteria) {
		Specification<Usuario> specification = Specification.where(null);
		if (criteria == null) {
			return specification;
		}
		if (criteria.getNombre() != null) {
			//specification = specification.and(this.buildStringSpecification(criteria.getNombre(), Usuario_.nombre));


		}
		if (criteria.getEmail() != null) {
			//specification = specification.and(this.buildStringSpecification(criteria.getEmail(), Usuario_.email));

		}
		if (criteria.getPrimerapellido()!= null) {
			//specification = specification.and(this.buildStringSpecification(criteria.getPrimerapellido(), Usuario_.primerapellido));

		}
		if (criteria.getSegundoapellido() != null) {
			//specification = specification.and(this.buildStringSpecification(criteria.getSegundoapellido(), Usuario_.segundoapellido));

		}


		return specification;
	}


	private static UsuarioCriteria createCriteria(UsuarioBusqueda dto) {
		UsuarioCriteria usuarioCriteria = new UsuarioCriteria();
		if (dto != null) {
			if (!StringUtils.isBlank(dto.getNombre())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getNombre());

				usuarioCriteria.setNombre(filter);
			}
			if (!StringUtils.isBlank(dto.getEmail())) {
				StringFilter filter = new StringFilter();

				filter.setContains(dto.getEmail());
				usuarioCriteria.setEmail(filter);
			}
			if (!StringUtils.isBlank(dto.getPrimerapellido())) {
				StringFilter filter = new StringFilter();

				filter.setContains(dto.getPrimerapellido());
				usuarioCriteria.setEmail(filter);
			}
			if (!StringUtils.isBlank(dto.getSegundoapellido())) {
				StringFilter filter = new StringFilter();

				filter.setContains(dto.getSegundoapellido());
				usuarioCriteria.setEmail(filter);
			}

		}
		return usuarioCriteria;
	}

}
