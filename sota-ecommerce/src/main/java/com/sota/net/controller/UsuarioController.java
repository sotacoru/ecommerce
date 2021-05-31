package com.sota.net.controller;

import com.sota.net.configuration.security.jwt.JwtProvider;
import com.sota.net.entity.Usuario;
import com.sota.net.repository.IUsuarioRepository;
import com.sota.net.service.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sota.net.entity.dto.GetUsuarioDto;
import com.sota.net.entity.dto.UsuarioDtoConverter;
import com.sota.net.model.JwtUserResponse;
import com.sota.net.model.LoginRequest;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {

	private final IUsuarioRepository usuarioRepository;
	private final UsuarioDtoConverter usuarioDtoConverter;

	private final IUsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;

	public IUsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}


	// MOSTRAR TODOS LOS USUARIOS
	@GetMapping("/usuario")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}

	// MOSTRAR USUARIO POR ID
	@RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> show(@PathVariable Long idUsuario) {
		Usuario usuario = usuarioService.findById(idUsuario);

		Map<String, Object> response = new HashMap<>();

		try {
			usuario = usuarioService.findById(idUsuario);
		} catch (DataAccessException e) {
			response.put("mensaje", "El usuario ID no existe en la BBDD");
			response.put("error", e.getMessage().concat(" : ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (usuario == null) {
			response.put("mensaje", "El usuario ID: ".concat(idUsuario.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	// CREACION USUARIOS
	@PostMapping("/usuario")
	public ResponseEntity<?> create(@RequestBody Usuario usuario, BindingResult result) {
		Usuario usuarioNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()).toString());
			usuarioNew = usuarioService.save(usuario);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert");
			response.put("error: ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido devuelto con exito!");
		response.put("producto", usuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// UPDATE USUARIOS
	@PutMapping("/usuario/{idUsuario}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, BindingResult result, @PathVariable Long idUsuario) {
		Usuario usuarioActual = usuarioService.findById(idUsuario);
		Usuario usuarioUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (usuarioActual == null) {
			response.put("mensaje",
					"Error, no se puede editar: ".concat(idUsuario.toString().concat(" no existe en la BBDD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setPrimerapellido(usuario.getPrimerapellido());
			usuarioActual.setSegundoapellido(usuario.getSegundoapellido());
			usuarioActual.setEmail(usuario.getEmail());
			System.out.println("Estamos dentro del try");
			System.out.println(usuario.getNombre());

			usuarioUpdated = usuarioService.save(usuarioActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert");
			response.put("error: ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con exito");
		response.put("usuario", usuarioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtUserResponse> loginPrueba(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getEmail());
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						loginRequest.getEmail(),
						loginRequest.getPassword()
						));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		System.out.println("dlnssd,mnds,mndsds,b");
		Usuario nuevoUsuario = (Usuario) authentication.getPrincipal();
		String jwtToken = jwtProvider.generateToken(authentication);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(convertUserEntityAndTokenToJwtUserResponse(nuevoUsuario, jwtToken));
	}


	@PreAuthorize("isAuthenticated()")
	@GetMapping("/usuario/me")
	public GetUsuarioDto yo(@AuthenticationPrincipal Usuario usuario) {
		return usuarioDtoConverter.converUsuarioEntityToGetUserDto(usuario);
	}

	private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(Usuario nuevoUsuario, String jwtToken) {
		return JwtUserResponse
				.jwtUserResponseBuilder()
				.nombre(nuevoUsuario.getNombre())
				.primerApellido(nuevoUsuario.getPrimerapellido())
				.segundoApellido(nuevoUsuario.getSegundoapellido())
				.email(nuevoUsuario.getEmail())
				.perfil(nuevoUsuario.getPerfil())
				.token(jwtToken)
				.build();

	}

}
