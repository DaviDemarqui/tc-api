package br.com.demarqui.demarqui.service;


import br.com.demarqui.demarqui.model.Client;
import br.com.demarqui.demarqui.repository.ClientRepository;
import br.com.demarqui.demarqui.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client){ return clientRepository.save(client); }

    public List<Client> allClient(){ return clientRepository.findAll(); }

    public Client updClient(Client client){
        return clientRepository.save(client);
    }

    public Client findById(Long id){
        return clientRepository.findClientById(id)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado."));
    }
    public void delClient(Long id) {
        clientRepository.deleteClientById(id);
    }
    public Optional<Client> findClientById(Long id) { return clientRepository.findClientById(id); }
}
