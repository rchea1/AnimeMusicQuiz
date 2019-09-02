package com.knotts.animemusicquiz.animemusicquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knotts.animemusicquiz.animemusicquiz.entity.Anime;
import com.knotts.animemusicquiz.animemusicquiz.service.AnimeService;

@Controller
@RequestMapping("/anime")
public class AnimeController {
	
	@Autowired
	private AnimeService animeService;
	
	@GetMapping("/")
	public String animeHome() {
		return "/anime/index";
	}

	@GetMapping("/list")
	public String showAnimeList(Model model) {
		List<Anime> anime = animeService.findAllByOrderByFirstNameAsc();
		model.addAttribute("anime", anime);
		model.addAttribute("animeModel", new Anime());
		return "/anime/list";
	}
	
	@GetMapping("/{id}")
	public String getAnime(@PathVariable int id, Model model) {
		Anime anime = null;
		try {
			anime = animeService.get(id);
			model.addAttribute("anime", anime);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "/anime/anime-form";
	}
	
	@GetMapping("/new")
	public String newAnime(Model model) {
		Anime anime = new Anime();
		model.addAttribute("anime", anime);
		return "/anime/anime-form";
	}
	
	@PostMapping("/")
	public Anime addAnime(@RequestBody Anime anime) {
		anime.setId(0);
		
		animeService.save(anime);
		
		return anime;
	}
	
	@PostMapping("/save")
	public String saveAnime(@ModelAttribute("anime") Anime anime) {
		animeService.save(anime);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/anime/list";
	}
	
}
