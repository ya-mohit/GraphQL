package com.mohit.graphQL.service;

import com.mohit.graphQL.entity.Movie;
import com.mohit.graphQL.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Cacheable(value = "movie", key = "#id")
    public Movie getAMovieById(int id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Cacheable(value = "movieByName", key = "#name")
    public Movie getAMovieByName(String name) {
        return movieRepo.findByName(name);
    }

    @Cacheable(value = "allMovies")
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Cacheable(value = "moviesByCategory", key = "#category")
    public List<Movie> getMoviesByCategory(String category) {
        return movieRepo.findByCategory(category);
    }

    @CacheEvict(value = {"allMovies", "moviesByCategory", "movieByName"}, allEntries = true)
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }
}
