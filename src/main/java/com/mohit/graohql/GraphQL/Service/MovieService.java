package com.mohit.graohql.GraphQL.Service;

import com.mohit.graohql.GraphQL.Entity.Movie;
import com.mohit.graohql.GraphQL.Repository.MovieRepo;
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
