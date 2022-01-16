package br.com.demarqui.demarqui.controller;

import br.com.demarqui.demarqui.dto.ClientDto;
import br.com.demarqui.demarqui.model.Client;
import br.com.demarqui.demarqui.service.ClientService;
import br.com.demarqui.demarqui.util.ResponseHandler;
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
    private ClientService clientService;

    ResponseHandler responseHandler;

    String infoString;
    HttpStatus httpStatus;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients () {

        List<Client> clients = clientService.allClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Object> getClient(@PathVariable("id") Long id) {

        Optional<Client> client = clientService.findClientById(id);

        if(client == null) {
            infoString = "Todos os clientes encontrados";
            httpStatus = HttpStatus.FOUND;
        } else {
            infoString = "Não a nenhum cliente com esse ID";
            httpStatus = HttpStatus.OK;
        }

        return ResponseHandler.generateResponse(infoString, httpStatus, client);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addClient(@RequestBody ClientDto client) {

        Boolean clientAlreadyExist = clientService.clientAlreadyExist(client);

        if(clientAlreadyExist == true) {
            httpStatus = HttpStatus.FOUND;
            infoString = "este cliente já existe";
        } else {
            httpStatus = HttpStatus.CREATED;
            infoString = "Cliente adicionado com sucesso";
            clientService.addClient(client);
        }

        return  ResponseHandler.generateResponse(infoString, httpStatus, client);
    }

    @PutMapping("/update")
    public  ResponseEntity<Object> updClient(@RequestBody ClientDto client) {

        Boolean clientAlreadyExist = clientService.clientAlreadyExist(client);

        if (clientAlreadyExist == true) {
            httpStatus = HttpStatus.FOUND;
            infoString = "Cliente Atualizado com sucesso";
            clientService.updClient(client);
        } else {
            httpStatus = HttpStatus.OK;
            infoString = "Não existe um cliente com esses dados para ser atualizado";
        }

        return ResponseHandler.generateResponse(infoString, httpStatus, client);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delClient(@PathVariable("id") Long id) {
        clientService.delClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
