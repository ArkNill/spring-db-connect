package com.mycom.sound.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.mycom.sound.dto.ElasticSound;

@Repository("ElasticSoundRepository")
public interface ElasticSoundRepository extends ElasticsearchCrudRepository<ElasticSound, String>{
	List<ElasticSound> findBycategory(String category);
}
