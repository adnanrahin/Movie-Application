package com.spring.boot.movie.app.test;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.model.City;
import com.spring.boot.movie.app.services.CityService;
import com.spring.boot.movie.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TestController {

    private final CountryService service;

    @Autowired
    public TestController(CountryService service) {
        this.service = service;
    }

    public void show() {
        service.findAll().forEach(c -> {
            System.out.println(c.getCountry());
            System.out.println("###########################################");
            List<City> address = c.getCities();
            address.forEach(city -> System.out.println(city.getCity()));
            System.out.println("###########################################");
        });
    }

}
