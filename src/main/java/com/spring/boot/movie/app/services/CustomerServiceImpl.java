package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Customer;
import com.spring.boot.movie.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CrudService<Customer, Long> {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findById(Long aLong) {
        return null;
    }

    @Override
    public Customer save(Customer object) {
        return null;
    }

    @Override
    public void delete(Customer object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
