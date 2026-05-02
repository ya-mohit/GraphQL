package com.mohit.graohql.GraphQL.Service;

import com.mohit.graohql.GraphQL.Entity.Movie;
import com.mohit.graohql.GraphQL.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public Movie getAMovieById(int id) {
        return movieRepo.findById(id).orElse(null);
    }

    public Movie getAMovieByName(String name) {
        return movieRepo.findByName(name);
    }

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> getMoviesByCategory(String category) {
        return movieRepo.findByCategory(category);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }
}
