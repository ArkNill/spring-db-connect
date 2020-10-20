package kr.co.inspect.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import kr.co.inspect.repository.ElasticRepository;
import kr.co.inspect.vo.ElasticDTO;

@Configuration
@EnableElasticsearchRepositories(basePackages= {"kr.co.inspect.repository"})
public class ElasticConfig {
	@Autowired 
	ElasticsearchOperations elasticsearchOperations;
	
	@Autowired 
	ElasticRepository repository;

	@PreDestroy //소멸 메소드
	public void deleteIndex() {
		System.out.println("deleteIndex 실행");
		elasticsearchOperations.indexOps(ElasticDTO.class).delete();
	}

	@PostConstruct //초기화 메소드
	public void insertDataSample() {
		System.out.println("insertDataSample 실행");
		repository.deleteAll();
		System.out.println("insertDataSample deleteAll 실행");
		elasticsearchOperations.indexOps(ElasticDTO.class).refresh();

		// 샘플 데이터 저장
		repository.save(ElasticDTO.builder()
									.label("lecture")
									.title("영어 강의")
									.date("2020-10-19")
									.company("ebs")
									.content("영어 강의~~~~~~~~~~~~~~~~")
									.build());
		repository.save(ElasticDTO.builder()
									.label("lecture")
									.title("과학 강의")
									.date("2020-10-19")
									.company("ebs")
									.content("과학 강의~~~~~~~~~~~~~")
									.build());
		repository.save(ElasticDTO.builder()
									.label("meeting")
									.title("주간 회의")
									.date("2020-10-20")
									.company("namu")
									.content("주간 회의~~~~~~~~~~")
									.build());
		repository.save(ElasticDTO.builder()
									.label("meeting")
									.title("임원 회의")
									.date("2020-10-20")
									.company("other")
									.content("임원 회의 내용~~~~~~~~~~~")
									.build());
	}
}
