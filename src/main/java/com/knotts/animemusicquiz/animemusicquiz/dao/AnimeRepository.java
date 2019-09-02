package com.knotts.animemusicquiz.animemusicquiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knotts.animemusicquiz.animemusicquiz.entity.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {
	public List<Anime> findAllByOrderByTitleAsc();
}
