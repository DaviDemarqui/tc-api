package br.com.demarqui.demarqui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 35, nullable = false)
    private String name;

    @Column(length = 35)
    private String email;

    @Column(length = 13)
    private String phone;

    @CPF
    private String cpf;

    @OneToMany
    @JoinColumn(name = "equipament_id")
    private List<Equipamento> equipamentoDoClient;
}
