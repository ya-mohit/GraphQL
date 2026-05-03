package com.mohit.graphQL.repository;

import com.mohit.graphQL.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    // LazyInitializationException - the classic "Lazy Loading" problem with Hibernate and GraphQL.
    // So need to write Query with JOIN FETCH to load the reviews along with the movies to avoid this problem.

    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.reviews")
    List<Movie> findAll();
    
    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.reviews WHERE m.id = :id")
    Optional<Movie> findById(@Param("id") Integer id);
    
    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.reviews WHERE m.category = :category")
    List<Movie> findByCategory(@Param("category") String category);
    
    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.reviews WHERE m.name = :name")
    Movie findByName(@Param("name") String name);
}
