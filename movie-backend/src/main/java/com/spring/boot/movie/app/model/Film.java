package com.spring.boot.movie.app.model;

import com.spring.boot.movie.app.model._enums.Rating;
import com.spring.boot.movie.app.model._enums.SpecialFeatures;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "film")
public class Film {

    public Film() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private String releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Column(name = "original_language_id")
    private Long originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    @Column(name = "rating")
    private Rating rating;

    @Column(name = "special_features")
    private SpecialFeatures specialFeatures;

    @Column(name = "last_update")
    private Timestamp timestamp;

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguageId() {
        return language;
    }

    public void setLanguageId(Language languageId) {
        this.language = languageId;
    }

    public Long getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Long originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public SpecialFeatures getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(SpecialFeatures specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
