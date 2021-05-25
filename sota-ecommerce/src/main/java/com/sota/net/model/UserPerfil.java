package com.sota.net.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserPerfil {

	@JsonProperty("CLIENTE")
	CLIENTE, @JsonProperty("SECRETARIO")
	SECRETARIO, @JsonProperty("ADMINISTRADOR")
	ADMINISTRADOR

}
