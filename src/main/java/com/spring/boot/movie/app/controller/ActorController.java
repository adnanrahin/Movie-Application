package com.spring.boot.movie.app.controller;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/actors")
@Controller
public class ActorController {

    private final CrudService<Actor, Long> actorService;

    /*Hard Coded Result*/

    @Autowired
    public ActorController(CrudService<Actor, Long> actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getActorList(Model model) {
        model.addAttribute("actors", actorService.findAll());
        return "actors/index";
    }

}
