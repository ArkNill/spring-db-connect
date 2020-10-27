package kr.com.inspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.MongoDao;

@Controller
public class MongoController {
	@Autowired
	private ElasticDao elasticDao;
	
	@Autowired
	private MongoDao mongoDao;
	
	//엘라스틱서치
	private String index = "audiolist";
	
	//몽고DB
	private String database = "audioDB";
	private String col = index;
	
	/* 엘라스틱서치 페이지 이동 */
	@GetMapping("/mongoPage")
	public String moveToElasticPage() {
		return "mongoDB/mongoPage";
	}
	
	/* 엘라스틱서치 특정 인덱스를 몽고DB 특정 컬렉션에 넣기 */
	@GetMapping("/insertElasticIndexToMongo")
	public String insertElasticIndexToMongo() {
		mongoDao.insertElasticIndex(database, col, index);
		//mongoDao.close();
		//elasticDao.close();
		
		return "mongoDB/insertElasticIndex";
	}
}
