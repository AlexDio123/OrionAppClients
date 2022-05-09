package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final  ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
}

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());

        if (clientOptional.isPresent()){
            throw  new IllegalStateException("email taken");
        }

        clientRepository.save(client);

    }


    public void deleteClient(Long clientID) {
       boolean exists = clientRepository.existsById(clientID);

       if(!exists){
           throw new IllegalStateException("client with id" + clientID + "does not exists");
       } 

       clientRepository.deleteById(clientID);

    }
    @Transactional
    public void updateClient(Long clientID, String name, String email) {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new IllegalStateException(
                   "client with id "+ clientID + " does not exists"
                ));
        if(name != null && name.length() >0 &&
        !Objects.equals(client.getName(), name)){
            client.setName(name);
        }
        if(email != null && email.length()>0 &&
    !Objects.equals(client.getEmail(), email)) {
            Optional<Client> clientOptional = clientRepository.findClientByEmail(email);

            if(clientOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            client.setEmail(email);
        }
    }
}
