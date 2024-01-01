package com.spring.boot.movie.app.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

}
