package br.com.demarqui.demarqui.repository;

import br.com.demarqui.demarqui.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    void deleteClientById(Long id);
    Optional<Client> findClientById(Long id);
    List<Client> findAllByCpf(String cpf);
}
