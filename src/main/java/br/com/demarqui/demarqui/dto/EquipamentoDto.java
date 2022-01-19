package br.com.demarqui.demarqui.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EquipamentoDto {

    private Long id;

    @Size(max = 100, message = "limite de caracteres {max} atingido")
    @NotNull(message = "o campo nome do equipamento é obrigatorio")
    private String nomeDoEquipamento;

    @Size(max = 100, message = "limite de caracteres {max} atingido")
    @NotNull(message = "o campo descricao do equipamento é obrigatorio")
    private String descricaoDoEquipamento;

    @Size(max = 100, message = "limite de caracteres {max} atingido")
    @NotNull(message = "o campo defeito do equipamento é obrigatorio")
    private String defeitoDoEquipamento;

    private ClientDto donoDoEquipamento;

}
