package com.spring.boot.movie.app.services;

import com.spring.boot.movie.app.model.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(Long id);

    Actor save(Actor object);

    void delete(Actor object);

    void deleteById(Long id);
}
