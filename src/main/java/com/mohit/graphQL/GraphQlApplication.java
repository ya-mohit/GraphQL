package com.mohit.graphQL;

import com.mohit.graphQL.repository.MovieRepo;
import com.mohit.graphQL.util.SampleMovieData;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication {

	@Autowired
	MovieRepo movieRepo;

	@PostConstruct
	private void init() {
		movieRepo.saveAll(
				SampleMovieData.getSampleMovies()
		);
	}


	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}


}
