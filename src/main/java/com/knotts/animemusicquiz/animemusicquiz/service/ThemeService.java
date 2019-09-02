package com.knotts.animemusicquiz.animemusicquiz.service;

import java.util.List;

import com.knotts.animemusicquiz.animemusicquiz.entity.Theme;

public interface ThemeService {
	
	public Theme get(int id);
	
	public List<Theme> findAll();
	
	public List<Theme> findAllByOrderByTitleAsc();
	
	public void deleteById(int id);

	public void save(Theme theme);
	
}
