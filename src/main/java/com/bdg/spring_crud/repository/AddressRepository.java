package com.bdg.spring_crud.repository;

import com.bdg.spring_crud.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByCountry(String country);

    List<Address> findAllByCity(String city);

    Optional<Address> findByCountryAndCity(String country, String city);

    boolean existsByCountry(String country);

    boolean existsByCity(String city);

    boolean existsByCountryAndCity(String country, String city);

    void deleteAllByCountry(String country);

    void deleteAllByCity(String city);
}