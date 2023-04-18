package com.example.cinema_api.services;

import com.example.cinema_api.models.Movie;
import com.example.cinema_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    private Movie movie;

    public MovieService(){

    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(String title, String rating, Integer duration){
        Movie movie = new Movie(title, rating, duration);
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }

    public void removeMovieById(int id){
        movieRepository.deleteById(id);
    }

    public void updateMovie(int id, String title, String rating, Integer duration){
        Movie movie = movieRepository.findById(id).get();
        movie.setDuration(duration);
        movie.setTitle(title);
        movie.setRating(rating);
        movieRepository.save(movie);
    }

    public List<Movie> getAllMoviesByDuration(Integer duration){
        List<Movie> movies = movieRepository.findAll();
        movies.removeIf(movie -> movie.getDuration() > duration);
        return movies;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
