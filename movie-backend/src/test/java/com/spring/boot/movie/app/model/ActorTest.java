package com.spring.boot.movie.app.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

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

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFirstName() {
        actor.setFirstName("Michale");
        assertEquals("Michale", actor.getFirstName());
    }

    @Test
    void getLastName() {
        actor.setLastName("Carter");
        assertEquals("Carter", actor.getLastName());
    }

    @Test
    void getLastUpdate() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        actor.setLastUpdate(currentTimestamp);
        assertEquals(currentTimestamp, actor.getLastUpdate());
    }

    @Test
    void getFilms() {
    }
}
