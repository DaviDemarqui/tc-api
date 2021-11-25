package com.demarqui.app.dto;

import lombok.Data;

@Data
public class ClienteDto {
	
	private String nome;
	private int cpf;
	private int telefone;
	private String endereco;
}
