package com.knotts.animemusicquiz.animemusicquiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knotts.animemusicquiz.animemusicquiz.entity.Anime;
import com.knotts.animemusicquiz.animemusicquiz.service.AnimeService;

@RestController
@RequestMapping("/api")
public class AutocompleteController {

	@Autowired
	AnimeService animeService;
	
	@GetMapping("/retrieveTitles")
	public List<String> getAnimeTitles() {
		List<Anime> anime = animeService.findAllByOrderByFirstNameAsc();
		List<String> titles = new ArrayList<>();
		for(Anime a : anime) {
			titles.add(a.getTitle());
		}
		return titles;
	}
}
