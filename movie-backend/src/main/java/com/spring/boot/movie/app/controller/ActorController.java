package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/getAllActor")
    public List<Actor> getAllActor() {
        return (List<Actor>) actorService.findAll();
    }

    @PostMapping("/save")
    public void saveActor(@RequestBody Actor object) {
        actorService.save(object);
    }
}
