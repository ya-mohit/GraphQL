package com.mohit.graohql.GraphQL.Controller;

import com.mohit.graohql.GraphQL.Entity.Movie;
import com.mohit.graohql.GraphQL.Entity.Review;
import com.mohit.graohql.GraphQL.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieGraphController {

    @Autowired
    MovieService movieService;

    @QueryMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @QueryMapping
    public List<Movie> getMoviesByCategory(@Argument String category) {
        return movieService.getMoviesByCategory(category);
    }

    @MutationMapping
    public Movie addReviewToMovie(@Argument String name, @Argument Review review) {
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
