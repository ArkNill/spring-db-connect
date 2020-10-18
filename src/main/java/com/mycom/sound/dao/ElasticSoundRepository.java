package com.mycom.sound.dao;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.mycom.sound.dto.ElasticSound;

@Repository("ElasticSoundRepository")
public interface ElasticSoundRepository extends ElasticsearchRepository<ElasticSound, String>{
	Optional<ElasticSound> findByCategory(String category);
}
