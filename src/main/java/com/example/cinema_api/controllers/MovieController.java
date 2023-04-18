package com.example.cinema_api.controllers;


import com.example.cinema_api.models.Movie;
import com.example.cinema_api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestParam String title, @RequestParam String rating, @RequestParam Integer duration){
        movieService.addMovie(title, rating, duration);
        Movie movie = new Movie(title, rating, duration);
        return new ResponseEntity<> (movie, HttpStatus.OK);
    }


//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        List<Movie> movies = movieService.getAllMovies();
//        return new ResponseEntity<>(movies, HttpStatus.OK);
//    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeMovie(@PathVariable int id){
        movieService.removeMovieById(id);
        return new ResponseEntity<>("you have removed movie " + id, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable int id, @RequestParam String title, @RequestParam String rating, @RequestParam Integer duration){
        movieService.updateMovie(id, title, rating, duration);
        return new ResponseEntity<>("you have update movie " + title, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMoviesByDuration(@RequestParam(required = false) Integer maxDuration){
        if (maxDuration == null) {
            List<Movie> movies = movieService.getAllMovies();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } else {
            List<Movie> movies = movieService.getAllMoviesByDuration(maxDuration);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }




}
