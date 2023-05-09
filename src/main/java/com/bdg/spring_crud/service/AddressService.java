package com.bdg.spring_crud.service;

import com.bdg.spring_crud.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Optional<Address> findById(Long id);
    List<Address> findAll();
    List<Address> findAllByCity(String city);
    List<Address> findAllByCountry(String country);
    Address save(Address address);
    Address updateById(Long id, Address address);
    boolean deleteById(Long id);
    boolean deleteAllByCountry(String country);
    boolean deleteAllByCity(String city);

}