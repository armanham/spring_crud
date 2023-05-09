package com.bdg.spring_crud.service.impl;

import com.bdg.spring_crud.model.Address;
import com.bdg.spring_crud.repository.AddressRepository;
import com.bdg.spring_crud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bdg.spring_crud.validator.Validator.*;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<Address> findById(Long id) {
        checkId(id);
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> findAllByCity(String city) {
        checkNonNullAndNonEmptyString(city);
        return addressRepository.findAllByCity(city);
    }

    @Override
    public List<Address> findAllByCountry(String country) {
        checkNonNullAndNonEmptyString(country);
        return addressRepository.findAllByCountry(country);
    }

    @Override
    public Address save(Address address) {
        checkNull(address);

        if (addressRepository.existsByCountryAndCity(address.getCountry(), address.getCity())) {
            return null;
        }
        return addressRepository.save(address);
    }

    @Override
    public Address updateById(Long id, Address newAddress) {
        checkId(id);
        checkNull(newAddress);

        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            System.out.println("Address with " + id + " does not exists: ");
            return null;
        }

        Optional<Address> newAddressOptional = addressRepository.findByCountryAndCity(newAddress.getCountry(), newAddress.getCity());
        if (newAddressOptional.isPresent()) {
            System.out.println(newAddress + " already exists: ");
            return null;
        }

        Address updatable = optionalAddress.get();
        updatable.setCountry(newAddress.getCountry());
        updatable.setCity(newAddress.getCity());

        return addressRepository.save(updatable);
    }

    @Override
    public boolean deleteById(Long id) {
        checkId(id);

        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllByCountry(String country) {
        checkNonNullAndNonEmptyString(country);

        if (addressRepository.existsByCountry(country)) {
            addressRepository.deleteAllByCountry(country);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllByCity(String city) {
        checkNonNullAndNonEmptyString(city);

        if (addressRepository.existsByCity(city)) {
            addressRepository.deleteAllByCity(city);
            return true;
        }
        return false;
    }
}