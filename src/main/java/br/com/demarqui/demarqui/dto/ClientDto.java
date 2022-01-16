package br.com.demarqui.demarqui.dto;

import br.com.demarqui.demarqui.model.Equipamento;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClientDto {

    private Long id;

    @NotNull(message = "o valor não pode ser null")
    private String name;

    @NotNull(message = "o valor não pode ser null")
    private String email;

    @NotNull(message = "o valor não pode ser null")
    private String phone;

    @NotNull(message = "o valor não pode ser null")
    private String cpf;

    private List<Equipamento> equipamentoDoClient;
}
