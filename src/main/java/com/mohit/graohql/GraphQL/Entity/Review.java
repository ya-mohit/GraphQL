package com.mohit.graohql.GraphQL.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "Review")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;

    private String reviewerName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore // Prevent infinite recursion during JSON serialization
    private Movie movie;
}
