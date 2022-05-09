package com.example.demo.client;

import com.example.demo.address.Address;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Client {

    @Id
    @SequenceGenerator(
            name="client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;


    @OneToMany(mappedBy = "client")
    private List <Address> address;

    private String name;
    private String email;
    private String Phone;

    public Client() {
    }

    public Client(Long id, List<Address> address, String name, String email, String phone) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.email = email;
        Phone = phone;
    }
    public Client(List<Address> address, String name, String email, String phone) {
        this.address = address;
        this.name = name;
        this.email = email;
        Phone = phone;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }



    public List<Address> getAddress() {
        return address;
    }

}
