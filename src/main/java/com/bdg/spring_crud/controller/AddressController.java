package com.bdg.spring_crud.controller;

import com.bdg.spring_crud.model.Address;
import com.bdg.spring_crud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/new")
    public Address add(@RequestBody Address address) {
        return addressService.save(address);
    }

    @GetMapping(value = "/list")
    public List<Address> getAll() {
        return addressService.findAll();
    }

    @GetMapping(value = "/list/byId/{id}")
    public Optional<Address> getById(@PathVariable("id") Long id) {
        return addressService.findById(id);
    }

    @GetMapping(value = "/list/byCountry/{country}")
    public List<Address> getAllByCountry(@PathVariable("country") String country) {
        return addressService.findAllByCountry(country);
    }

    @GetMapping(value = "/list/byCity/{city}")
    public List<Address> getAllByCity(@PathVariable("city") String city) {
        return addressService.findAllByCity(city);
    }

    @DeleteMapping(value = "/delete/byId/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return addressService.deleteById(id);
    }

    @DeleteMapping(value = "/delete/byCountry/{country}")
    public boolean deleteAllByCountry(@PathVariable("country") String country) {
        return addressService.deleteAllByCountry(country);
    }

    @DeleteMapping(value = "/delete/byCity/{city}")
    public boolean deleteAllByCity(@PathVariable("city") String city) {
        return addressService.deleteAllByCity(city);
    }

    @PutMapping(value = "/update/{id}")
    public Address updateBy(@PathVariable("id") Long id, @RequestBody Address newAddress) {
        return addressService.updateById(id, newAddress);
    }
}