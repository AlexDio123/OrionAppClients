package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/client")
public class ClientController {


    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients() {
        return  clientService.getClients();

    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientID}")
    public void deleteClient(@PathVariable("clientID") Long clientID){

        clientService.deleteClient (clientID);
    }
    @PutMapping(path = "{clientID}")
    public void updateClient(@PathVariable("clientID") Long clientID,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email)
    {
        clientService.updateClient(clientID, name, email);
    }

}

