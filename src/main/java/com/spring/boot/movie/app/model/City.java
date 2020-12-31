package com.spring.boot.movie.app.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id", nullable = false)
    private Long addressId;

}
