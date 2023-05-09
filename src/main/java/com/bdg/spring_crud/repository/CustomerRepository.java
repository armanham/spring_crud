package com.bdg.spring_crud.repository;

import com.bdg.spring_crud.model.Address;
import com.bdg.spring_crud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByPhone(String phone);

    List<Customer> findAllByName(String name);

    List<Customer> findAllByAddress(Address address);

    boolean existsByPhone(String phone);

    boolean existsByName(String name);

    boolean existsByAddress(Address address);

    void deleteByPhone(String phone);

    void deleteAllByAddress(Address address);

    void deleteByName(String name);
}