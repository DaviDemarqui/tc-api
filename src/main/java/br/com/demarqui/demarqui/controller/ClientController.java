package br.com.demarqui.demarqui.controller;

import br.com.demarqui.demarqui.model.Client;
import br.com.demarqui.demarqui.service.ClientService;
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
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
         Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Client> updClient(@RequestBody Client client) {
        Client updateClient = clientService.updClient(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delClient(@PathVariable("id") Long id) {
        clientService.delClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
