package com.demarqui.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
	
	@NotBlank(message = "Esse campo é obrigatorio")
	@Column(nullable = false, length = 80)
	private String descricao;
	
	@NotBlank(message = "Esse campo é obrigatorio")
	@Column(nullable = false, length = 80)
	private String defeito;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	// TODO Descomentar para realizar a ligação
	//@OneToMany(mappedBy = "cliente")
	//private List<OrdemServico> ordensServico;
}
