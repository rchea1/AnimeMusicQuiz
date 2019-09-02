package com.knotts.animemusicquiz.animemusicquiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knotts.animemusicquiz.animemusicquiz.dao.AlternativeNameRepository;
import com.knotts.animemusicquiz.animemusicquiz.entity.AlternativeName;

@Service
public class AlternativeNameServiceImpl implements AlternativeNameService {

	@Autowired
	AlternativeNameRepository alternativeNameRepository;
	
	@Override
	public AlternativeName get(int id) {
		Optional<AlternativeName> result = alternativeNameRepository.findById(id);
		AlternativeName alternativeName = null;
		if(result.isPresent()) {
			alternativeName = result.get();
		}
		else {
			throw new RuntimeException("Did not find an alternativeName with id: " + id);
		}
		
		return alternativeName;
	}

	@Override
	public List<AlternativeName> findAll() {
		return alternativeNameRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		alternativeNameRepository.deleteById(id);

	}

	@Override
	public void save(AlternativeName alternativeName) {
		alternativeNameRepository.save(alternativeName);
	}

}
