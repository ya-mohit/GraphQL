package com.mohit.graohql.GraphQL.Controller;

import com.mohit.graohql.GraphQL.Entity.Movie;
import com.mohit.graohql.GraphQL.Entity.Review;
import com.mohit.graohql.GraphQL.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
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
            // Initialize reviews list if null
            if (movie.getReviews() == null) {
                movie.setReviews(new java.util.ArrayList<>());
            }
            // Set the bidirectional relationship
            review.setMovie(movie);
            // Add review to the movie
            movie.getReviews().add(review);
            // Save the updated movie with the new review
            movieService.saveMovie(movie);
            return movie;
        }
        throw new IllegalArgumentException("Movie not found with name: " + name);
    }

}
