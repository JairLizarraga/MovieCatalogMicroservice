package com.example.mif.resources;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mif.models.Movie;

@RestController
@RequestMapping("/movieinfo")
public class MoviesResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieById(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "name"+movieId, "descriprion"+movieId);
	}

}
