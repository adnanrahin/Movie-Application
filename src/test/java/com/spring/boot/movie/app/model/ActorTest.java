package com.spring.boot.movie.app.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    Actor actor;

    @BeforeEach
    public void setUp() {
        actor = new Actor();
    }

    @Test
    void getId() {
        actor.setActorId(6L);

        assertEquals(6L, actor.getActorId());
    }

}
