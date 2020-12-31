package com.spring.boot.movie.app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "actor", schema = "sakila")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private Long actorId;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long id) {
        this.actorId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return actorId.equals(actor.actorId) &&
                firstName.equals(actor.firstName) &&
                lastName.equals(actor.lastName) &&
                lastUpdate.equals(actor.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, lastUpdate);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
