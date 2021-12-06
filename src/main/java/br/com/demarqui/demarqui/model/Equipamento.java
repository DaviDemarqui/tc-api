package br.com.demarqui.demarqui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, name = "equipamentName")
    private String nomeDoEquipamento;

    @Column(length = 100, name = "equipamentDescription")
    private String descricaoDoEquipamento;

    @Column(length = 50, name = "equipamentProblem")
    private String defeitoDoEquipamento;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client donoDoEquipamento;
}
