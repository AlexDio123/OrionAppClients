package com.example.demo.address;

import com.example.demo.client.Client;
import com.example.demo.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/addresss")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ClientRepository clientRepository;


    @GetMapping
    List<Address> getAddress(){return addressRepository.findAll();}

    @PostMapping
    Address createAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @PutMapping(path = "/{clientID}/clients/{addressID}")
    Address assingClientToAddress(@PathVariable Long clientID,
                                   @PathVariable Long addressID){
        Client client = clientRepository.findById(clientID).get();
        Address address = addressRepository.findById(addressID).get();
        address.setAddress(client);

        return addressRepository.save(address);

    }
}
