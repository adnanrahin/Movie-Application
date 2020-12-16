package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public String getActorList(Model model) {
        model.addAttribute("actors", actorService.findAll());
        return "list";
    }

}
