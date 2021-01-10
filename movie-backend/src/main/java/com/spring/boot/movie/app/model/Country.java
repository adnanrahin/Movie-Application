package com.spring.boot.movie.app.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@ToString
@Entity
@Table(name = "country")
@Data
public class Country {

    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<City> cities;
}
