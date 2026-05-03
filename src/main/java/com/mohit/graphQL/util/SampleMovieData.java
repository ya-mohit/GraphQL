package com.mohit.graphQL.util;

import com.mohit.graphQL.entity.Movie;
import com.mohit.graphQL.entity.Review;

import java.util.ArrayList;
import java.util.List;

public class SampleMovieData {

    public static List<Movie> getSampleMovies() {
        List<Movie> movies = new ArrayList<>();

        // Movie 1
        Review review1 = new Review(null, "An absolute masterpiece! Brilliant direction and acting.", 5, "John Smith", null);
        Movie movie1 = new Movie(null, "The Shawshank Redemption", "Drama", "Frank Darabont", 1994, List.of(review1));
        review1.setMovie(movie1); // Set the bidirectional reference
        movies.add(movie1);

        // Movie 2
        Review review2 = new Review(null, "Outstanding villain and thrilling plot twists.", 5, "Sarah Johnson", null);
        Movie movie2 = new Movie(null, "The Dark Knight", "Action", "Christopher Nolan", 2008, List.of(review2));
        review2.setMovie(movie2);
        movies.add(movie2);

        // Movie 3
        Review review3 = new Review(null, "A timeless classic that everyone must watch.", 4, "Michael Chen", null);
        Movie movie3 = new Movie(null, "Forrest Gump", "Drama", "Robert Zemeckis", 1994, List.of(review3));
        review3.setMovie(movie3);
        movies.add(movie3);

        // Movie 4
        Review review4 = new Review(null, "Visually stunning and emotionally engaging.", 5, "Emma Wilson", null);
        Movie movie4 = new Movie(null, "Inception", "Sci-Fi", "Christopher Nolan", 2010, List.of(review4));
        review4.setMovie(movie4);
        movies.add(movie4);

        // Movie 5
        Review review5 = new Review(null, "A must-watch for superhero fans. Great action sequences.", 4, "David Brown", null);
        Movie movie5 = new Movie(null, "Avengers: Endgame", "Action", "Anthony and Joe Russo", 2019, List.of(review5));
        review5.setMovie(movie5);
        movies.add(movie5);

        // Movie 6
        Review review6 = new Review(null, "A touching story that will make you laugh and cry.", 4, "Lisa Anderson", null);
        Movie movie6 = new Movie(null, "The Pursuit of Happyness", "Drama", "Gabriele Muccino", 2006, List.of(review6));
        review6.setMovie(movie6);
        movies.add(movie6);

        return movies;
    }
}
