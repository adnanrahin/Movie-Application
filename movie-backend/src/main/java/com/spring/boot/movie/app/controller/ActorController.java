package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.GET, path = "/getAllActor")
    public ResponseEntity<List<Actor>> getAllActor() {
        return ResponseEntity.ok(actorService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public ResponseEntity<?> saveActor(@RequestBody Actor object) {
        return ResponseEntity.ok(actorService.save(object));
    }
}
