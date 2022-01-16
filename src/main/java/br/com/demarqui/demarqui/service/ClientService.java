package br.com.demarqui.demarqui.service;


import br.com.demarqui.demarqui.dto.ClientDto;
import br.com.demarqui.demarqui.model.Client;
import br.com.demarqui.demarqui.repository.ClientRepository;
import br.com.demarqui.demarqui.util.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    public Client addClient(ClientDto client){
        Client cli = modelMapper.map(client, Client.class);
        return clientRepository.save(cli);
    }

    public List<Client> allClient(){
        return clientRepository.findAll();
    }

    public Client updClient(ClientDto client){

        Client cli = modelMapper.map(client, Client.class);
        return clientRepository.save(cli);
    }

    public Client findById(Long id){
        return clientRepository.findClientById(id)
                .orElseThrow(() -> new UserNotFoundException("Cliente não encontrado."));
    }

    public Boolean clientAlreadyExist(ClientDto client){
        Client cli = modelMapper.map(client, Client.class);
        Boolean bol = clientRepository.existsById(cli.getId());
        return bol;
    }

    public void delClient(Long id) {
        clientRepository.deleteClientById(id);
    }
    public Optional<Client> findClientById(Long id) { return clientRepository.findClientById(id); }
}
