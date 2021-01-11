package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actor")
    public List<Actor> getActors() {
        return (List<Actor>) actorService.findAll();
    }
}
