package com.bdg.spring_crud.service.impl;

import com.bdg.spring_crud.model.Address;
import com.bdg.spring_crud.model.Customer;
import com.bdg.spring_crud.repository.CustomerRepository;
import com.bdg.spring_crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bdg.spring_crud.validator.Validator.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findByPhone(Long id) {
        checkId(id);
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllByName(String name) {
        checkNonNullAndNonEmptyString(name);
        return customerRepository.findAllByName(name);
    }

    @Override
    public List<Customer> findAllByName(Address address) {
        checkNull(address);
        return customerRepository.findAllByAddress(address);
    }

    @Override
    public Customer findByPhone(String phone) {
        checkNonNullAndNonEmptyString(phone);
        return customerRepository.findByPhone(phone);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        checkNull(customer);

        if (customerRepository.existsByPhone(customer.getPhone())) {
            System.out.println(customer.getPhone() + " phone number already exists: ");
            return null;
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateById(Long id, Customer newCustomer) {
        checkId(id);
        checkNull(newCustomer);

        if (!customerRepository.existsById(id)) {
            System.out.println("Customer with " + id + " does not exist: ");
            return null;
        }

        if (customerRepository.existsByPhone(newCustomer.getPhone())) {
            System.out.println(newCustomer.getPhone() + " phone number already exists: ");
            return null;
        }

        Customer updatable = customerRepository.findById(id).get();
        updatable.setName(newCustomer.getName());
        updatable.setAge(newCustomer.getAge());
        updatable.setPhone(newCustomer.getPhone());
        updatable.setAddress(newCustomer.getAddress());
        return customerRepository.save(updatable);
    }

    @Override
    public boolean deleteById(Long id) {
        checkId(id);

        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByPhone(String phone) {
        checkNonNullAndNonEmptyString(phone);

        if (customerRepository.existsByPhone(phone)) {
            customerRepository.deleteByPhone(phone);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllBy(String name) {
        checkNonNullAndNonEmptyString(name);

        if (customerRepository.existsByName(name)) {
            customerRepository.deleteByName(name);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllByAddress(Address address) {
        checkNull(address);

        if (customerRepository.existsByAddress(address)) {
            customerRepository.deleteAllByAddress(address);
            return true;
        }
        return false;
    }
}