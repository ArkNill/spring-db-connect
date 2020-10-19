package com.mycom.sound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mycom.sound.dao.ElasticSoundRepository;
import com.mycom.sound.dto.ElasticSound;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ElasticSoundService {
	private ElasticSoundRepository elasticSoundRepository;

	public void save(ElasticSound elasticSound) {
		elasticSoundRepository.save(elasticSound);
	}

	public List<ElasticSound> findAll() {
	    return Lists.newArrayList(elasticSoundRepository.findAll());
	}

	public List<ElasticSound> findByCategory(String category) {
	    return elasticSoundRepository.findBycategory(category);
	}
}
