package com.example.clientratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingResource {
	
	@RequestMapping("/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {

		UserRating ur = new UserRating();
		ur.initData(userId);
		return ur;
	}

}
