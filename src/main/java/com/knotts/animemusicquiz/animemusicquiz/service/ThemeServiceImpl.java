package com.knotts.animemusicquiz.animemusicquiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knotts.animemusicquiz.animemusicquiz.dao.ThemeRepository;
import com.knotts.animemusicquiz.animemusicquiz.entity.Theme;

@Service
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public Theme get(int id) {
		Optional<Theme> result = themeRepository.findById(id);
		Theme theme = null;
		if(result.isPresent()) {
			theme = result.get();
		}
		else {
			throw new RuntimeException("Did not find theme with id: " + id);
		}
		return theme;
	}

	@Override
	public List<Theme> findAll() {
		return themeRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		themeRepository.deleteById(id);

	}

	@Override
	public void save(Theme theme) {
		themeRepository.save(theme);
	}

	@Override
	public List<Theme> findAllByOrderByTitleAsc() {
		return themeRepository.findAllByOrderByTitleAsc();
	}

}
