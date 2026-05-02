package com.mohit.graohql.GraphQL.Repository;

import com.mohit.graohql.GraphQL.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
    List<Movie> findByCategory(String category);
    Movie findByName(String name);
}
