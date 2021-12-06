package br.com.demarqui.demarqui.repository;

import br.com.demarqui.demarqui.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipamentRepository extends JpaRepository<Equipamento, Long> {

}
