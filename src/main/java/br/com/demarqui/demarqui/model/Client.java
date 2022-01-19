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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @Column(length = 35, nullable = false, name = "clientName")
    private String name;

    @Column(length = 35, nullable = false, name = "clientEmail")
    private String email;

    @Column(length = 13, nullable = false, name = "clientPhone")
    private String phone;

    @Column(length = 14, nullable = false, name = "clientCpf", unique = true)
    private String cpf;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "equipament_id")
    private List<Equipamento> equipamentoDoClient;

}
