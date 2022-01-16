package br.com.demarqui.demarqui.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EquipamentoDto {

    private Long id;

    @NotNull(message = "valor não pode ser null")
    private String nomeDoEquipamento;

    @NotNull(message = "valor não pode ser null")
    private String descricaoDoEquipamento;

    @NotNull(message = "valor não pode ser null")
    private String defeitoDoEquipamento;
}
