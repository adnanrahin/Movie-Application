package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Customer;
import com.spring.boot.movie.app.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/customers")
@Controller
public class CustomerController {

    private final CrudService<Customer, Long> crudService;

    @Autowired
    public CustomerController(CrudService<Customer, Long> crudService) {
        this.crudService = crudService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getListOfCustomer(Model model) {

        model.addAttribute("customers", crudService.findAll());

        return "customers/index";
    }

}
