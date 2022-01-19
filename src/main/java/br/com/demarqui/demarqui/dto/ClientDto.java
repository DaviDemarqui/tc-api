package br.com.demarqui.demarqui.dto;

import br.com.demarqui.demarqui.model.Equipamento;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ClientDto {

    private Long id;

    @Size(max = 50, message = "limite de caracteres {max} atingido")
    @NotNull(message = "campo nome é obrigatorio")
    private String name;

    @Size(max = 50, message = "limite de caracteres {max} atingido")
    @NotNull(message = "campo email é obrigatorio")
    private String email;

    @Size(max = 11, message = "limite de caracteres {max} atingido")
    @NotNull(message = "campo telefone é obrigatorio")
    private String phone;

    @Size(max = 14, message = "limite de caracteres {max} atingido")
    @CPF(message = "cpf invalido")
    @NotNull(message = "campo cpf é obrigatorio")
    private String cpf;

    private List<EquipamentoDto> equipamentoDoClient;

}
