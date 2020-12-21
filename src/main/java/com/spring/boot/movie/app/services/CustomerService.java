package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer object);

    void delete(Customer object);

    void deleteById(Long id);

}
