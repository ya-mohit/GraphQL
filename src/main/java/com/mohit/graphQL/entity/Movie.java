package com.mohit.graphQL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity(name = "Movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String director;
    private int releaseYear;

    //EAGER Fetch instead of LAZY to avoid LazyInitializationException in GraphQL when fetching movies and their reviews.
    //This is done to prevent Cacheable and LazyInitializationException problem in GraphQL when fetching movies and their reviews.
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;
}
