package com.spring.boot.movie.app.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

}
