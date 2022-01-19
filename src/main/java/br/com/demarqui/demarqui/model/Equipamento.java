package br.com.demarqui.demarqui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;

    @Column(length = 30, name = "equipamentName")
    private String nomeDoEquipamento;

    @Column(length = 100, name = "equipamentDescription")
    private String descricaoDoEquipamento;

    @Column(length = 50, name = "equipamentProblem")
    private String defeitoDoEquipamento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Client donoDoEquipamento;
}
