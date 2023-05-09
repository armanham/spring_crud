package com.bdg.spring_crud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "address",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"country", "city"})
        }
)
public class Address extends BaseModel {

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}