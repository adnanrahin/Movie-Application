package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/address")
@Controller
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getActorList(Model model) {
        model.addAttribute("addresses", addressService.findAll());
        return "address/index";
    }
}
