package com.example.cinema_api.models;

import jakarta.persistence.*;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private String rating;

    @Column(name = "duration")
    private Integer duration;


    public Movie(String title, String rating, Integer duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public Movie(){

    }

//    GETTERS & SETTERS


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
