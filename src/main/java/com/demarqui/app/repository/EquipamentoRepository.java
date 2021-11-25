package com.demarqui.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demarqui.app.model.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>{

}
