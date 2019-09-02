package com.knotts.animemusicquiz.animemusicquiz.service;

import java.util.List;

import com.knotts.animemusicquiz.animemusicquiz.entity.AlternativeName;

public interface AlternativeNameService {

	public AlternativeName get(int id);
	
	public List<AlternativeName> findAll();
	
	public void deleteById(int id);

	public void save(AlternativeName alternativeName);
}
