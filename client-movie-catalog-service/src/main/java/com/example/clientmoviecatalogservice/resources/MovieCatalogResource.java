package com.example.clientmoviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.clientmoviecatalogservice.models.Catalog;
import com.example.clientmoviecatalogservice.models.Movie;
import com.example.clientmoviecatalogservice.models.UserRating;
import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/{userId}")
	public List<Catalog> getCatalog(@PathVariable("userId") String userId) {

		UserRating ratings = restTemplate.getForObject("http://client-ratings-data-service/rating/" + userId, UserRating.class);
		
		return ratings.getRatings().stream().map(rating -> 
		{
			Movie movie =  restTemplate.getForObject("http://client-movie-info-service/movieinfo/" + rating.getMovieId(), Movie.class);
			return new Catalog(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
		
	}

}
