package com.mycom.sound.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.mycom.sound.dto.ElasticSound;

@Repository("ElasticSoundRepository")
public interface ElasticSoundRepository extends ElasticsearchRepository<ElasticSound, String>{
	List<ElasticSound> findBycategory(String category);
}
