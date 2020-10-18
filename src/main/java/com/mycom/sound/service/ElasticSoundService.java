package com.mycom.sound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mycom.sound.dao.ElasticSoundRepository;
import com.mycom.sound.dto.ElasticSound;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ElasticSoundService {
	private ElasticSoundRepository elasticSoundRepository;
	
	public void save(ElasticSound elasticSound) {
		elasticSoundRepository.save(elasticSound);
	  }

	  public List<ElasticSound> findAll() {
	    return Lists.newArrayList(elasticSoundRepository.findAll());
	  }

	  public Optional<ElasticSound> findByCategory(String category) {
	    return elasticSoundRepository.findByCategory(category);
	  }
}
