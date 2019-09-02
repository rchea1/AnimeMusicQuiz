package com.knotts.animemusicquiz.animemusicquiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knotts.animemusicquiz.animemusicquiz.entity.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {

	public List<Theme> findAllByOrderByTitleAsc();
}
