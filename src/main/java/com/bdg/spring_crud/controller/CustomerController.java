package com.bdg.spring_crud.controller;

import com.bdg.spring_crud.model.Customer;
import com.bdg.spring_crud.service.AddressService;
import com.bdg.spring_crud.service.CustomerService;
import com.bdg.spring_crud.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final AddressService addressService;


    @Autowired
    public CustomerController(CustomerServiceImpl customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }


    @PostMapping(value = "/new")
    public @ResponseBody Customer save(@RequestBody Customer customer) {
        addressService.save(customer.getAddress());
        return customerService.save(customer);
    }
}