package com.knotts.animemusicquiz.animemusicquiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knotts.animemusicquiz.animemusicquiz.dao.AnimeRepository;
import com.knotts.animemusicquiz.animemusicquiz.entity.Anime;

@Service
public class AnimeServiceImpl implements AnimeService {

	@Autowired
	private AnimeRepository animeRepository;
	
	@Override
	public Anime get(int id) {
		Optional<Anime> result = animeRepository.findById(id);
		
		Anime anime = null;
		
		if(result.isPresent()) {
			anime = result.get();
		}
		else {
			throw new RuntimeException("Did not find anime with id: " + id);
		}
		return anime;
	}

	@Override
	public void deleteById(int id) {
		animeRepository.deleteById(id);
	}
	
	@Override
	public List<Anime> findAll() {
		return animeRepository.findAll();
	}
	
	@Override
	public void save(Anime anime) {
		animeRepository.save(anime);
	}

	@Override
	public List<Anime> findAllByOrderByFirstNameAsc() {
		return animeRepository.findAllByOrderByTitleAsc();
	}

}
