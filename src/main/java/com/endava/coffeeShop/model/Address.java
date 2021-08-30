package com.endava.coffeeShop.model;

import javax.persistence.*;

@Entity
@Table(name = "ADRESSES")
public class Address {

    @Id
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NR")
    private int nr;

    @OneToOne
    @MapsId
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Address() {
    }

    public Address(Long id, String street, int nr) {
        this.id = id;
        this.street = street;
        this.nr = nr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}


