package kr.co.inspect.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import kr.co.inspect.vo.ElasticDTO;

public interface ElasticRepository extends ElasticsearchRepository<ElasticDTO, String>{}
