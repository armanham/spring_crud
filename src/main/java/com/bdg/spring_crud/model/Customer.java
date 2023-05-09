package com.bdg.spring_crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends BaseModel {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    public Customer(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}