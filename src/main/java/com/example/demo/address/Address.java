package com.example.demo.address;

import com.example.demo.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "Id")
    private Client client;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    private String name;

    public Long getId(){
        return Id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setAddress(Client client) {
        this.client = client;
    }
}
