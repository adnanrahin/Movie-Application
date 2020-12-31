package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.model.Category;

import java.util.List;

public interface AddressService {

    List<Address> findAll();

    Address findById(Long id);

    Address save(Address object);

    void delete(Address object);

    void deleteById(Long id);

}
