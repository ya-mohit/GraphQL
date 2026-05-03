package com.mohit.graphQL.controller;

import com.mohit.graphQL.entity.Movie;
import com.mohit.graphQL.entity.Review;
import com.mohit.graphQL.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return  movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getAProductById(@PathVariable int id) {
        return movieService.getAMovieById(id);
    }

    @PostMapping("/addReview/{name}")
    public Movie addReviewToMovie(@PathVariable String name, @RequestBody Review review) {
        Movie movie = movieService.getAMovieByName(name);
        if (movie != null) {
            if (movie.getReviews() == null) {
                movie.setReviews(new java.util.ArrayList<>());
            }
            // Set the bidirectional relationship
            review.setMovie(movie);
            movie.getReviews().add(review);
            movieService.saveMovie(movie);
            return movie;
        }
        throw new IllegalArgumentException("Movie not found with name: " + name);
    }
}