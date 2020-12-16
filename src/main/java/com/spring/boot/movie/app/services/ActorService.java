package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();

}
