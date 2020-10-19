package com.mycom.sound.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mycom.sound.dao.ElasticSoundRepository;
import com.mycom.sound.dto.ElasticSound;
import com.mycom.sound.service.ElasticSoundService;

public class ElasticsearchTest {
	ElasticSoundService elasticSoundService;

	@Autowired
	@Qualifier("elasticSoundRepository")
	ElasticSoundRepository elasticSoundRepository;

	@Before
	public void setup() {
		elasticSoundService = new ElasticSoundService(elasticSoundRepository);
	}
	
	@Test
	public void whenValidParameter_thenSuccessFind() {
	    List<ElasticSound> list = elasticSoundService.findBycategory("lecture");
	    System.out.println("리스트 : "+list);
	    assertNotNull(list);
	}

//	@Test
//	public void whenValidParameter_thenSuccessFind() {
//	    List<ElasticSound> list = elasticSoundService.findAll();
//	    assertNotNull(list);
//	}

//	@Test
//	public void whenValidParameter_thenSuccessSave() {
//		Exception ex = null;
//
//	    try {
//	    	elasticSoundService.save(ElasticSound.builder()
//	    										.category("lecture")
//	    										.title("음성 데이터 제목")
//	    										.company("EBS")
//	    										.content("음성 데이터 내용이 옴~~~")
//	    										.build());
//	    } catch (Exception exception) {
//	    	exception.printStackTrace();
//	    	ex = exception;
//	    }
//
//	    assertTrue(null == ex);
//	}
//
//	@Test
//	public void whenValidParameter_thenSuccessFindBycategory() {
//	    Exception ex = null;
//
//	    try {
//	    	ElasticSound ElasticSound = elasticSoundService.findByCategory("lecture");
//	    	System.out.println(ElasticSound);
//	    	assertThat(ElasticSound, is(IsNull.notNullValue()));
//	    } catch (Exception exception) {
//	    	exception.printStackTrace();
//	    	ex = exception;
//	    }
//
//	    assertTrue(null == ex);
//	}
}
