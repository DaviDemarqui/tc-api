package br.com.demarqui.demarqui.controller;

import br.com.demarqui.demarqui.dto.ClientDto;
import br.com.demarqui.demarqui.model.Client;
import br.com.demarqui.demarqui.repository.ClientRepository;
import br.com.demarqui.demarqui.repository.EquipamentRepository;
import br.com.demarqui.demarqui.service.ClientService;
import br.com.demarqui.demarqui.util.excepion.ResponseHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cliente")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    ModelMapper modelMapper;

    private ResponseHandler responseHandler;

    String infoString;

    HttpStatus httpStatus;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients () {

        List<Client> clients = clientService.allClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {

        Optional<Client> client = clientService.findClientById(id);
        return new ResponseEntity(client, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addClient(@RequestBody ClientDto client) {

        Client newClient = clientService.addClient(client);

        httpStatus = HttpStatus.CREATED;
        infoString = "Cliente Adicionado com Sucesso.";

        return ResponseHandler.generateResponse(infoString, HttpStatus.CREATED, newClient);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updClient(@RequestBody ClientDto client) {

        infoString = "Cliente Atualizado com sucesso";
        Client updateClient = clientService.updClient(client);
        return ResponseHandler.generateResponse(infoString, HttpStatus.CREATED, updateClient);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delClient(@PathVariable("id") Long id) {

        clientService.delClient(id);
        return new ResponseEntity<>(infoString, HttpStatus.ACCEPTED);
    }
}
