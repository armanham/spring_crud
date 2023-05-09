package com.bdg.spring_crud.service;

import com.bdg.spring_crud.model.Address;
import com.bdg.spring_crud.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findByPhone(Long id);

    List<Customer> findAllByName(String name);

    List<Customer> findAllByName(Address address);

    Customer findByPhone(String phone);

    List<Customer> findAll();

    Customer save(Customer customer);

    Customer updateById(Long id, Customer customer);

    boolean deleteById(Long id);

    boolean deleteByPhone(String phone);

    boolean deleteAllBy(String name);

    boolean deleteAllByAddress(Address address);

}