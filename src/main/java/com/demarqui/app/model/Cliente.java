package com.demarqui.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Conteúdo do campo é obrigatório.")
	@Size(max = 45, message = "Deve ter no máximo {max} caracteres.")
	@Column(nullable = false, length = 45)
	private String nome;

	@Column(length = 18)
	@CPF(message = "CPF inválido")
	private int cpf;
	
	@Column(length = 14)
	@Size(max = 14, message = "Deve ter no máximo {max} caracteres.")
	private int telefone;

	@Column(length = 80)
	@Size(max = 80, message = "Deve ter no máximo {max} caracteres.")
	private String endereco;
	
	@OneToMany(mappedBy = "cliente")
	private List<Equipamento> equipamentos;
	
	// TODO Descomentar para realizar a ligação
	//@OneToMany(mappedBy = "cliente")
	//private List<OrdemServico> ordensServico;
}
