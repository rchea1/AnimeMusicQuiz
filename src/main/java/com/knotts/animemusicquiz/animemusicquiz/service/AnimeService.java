package com.knotts.animemusicquiz.animemusicquiz.service;

import java.util.List;

import com.knotts.animemusicquiz.animemusicquiz.entity.Anime;

public interface AnimeService {

	public Anime get(int id);
	
	public List<Anime> findAll();
	
	public List<Anime> findAllByOrderByFirstNameAsc();
	
	public void deleteById(int id);

	public void save(Anime anime);
}
