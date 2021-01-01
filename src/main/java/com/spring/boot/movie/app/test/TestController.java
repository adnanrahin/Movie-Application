package com.spring.boot.movie.app.test;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TestController {

    private final CityService service;

    @Autowired
    public TestController(CityService service) {
        this.service = service;
    }

    public void showCity() {
        service.findAll().forEach(c -> {
            List<Address> address = c.getAddresses();
            address.forEach(address1 -> System.out.println(address1));
        });
    }

}
