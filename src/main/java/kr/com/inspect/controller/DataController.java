package kr.com.inspect.controller;

import org.apache.ibatis.session.SqlSession;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.MongoDao;

@Controller
public class DataController {
	@Autowired
	private ElasticDao elasticDao;
	
	@Autowired
	private MongoDao mongoDao;
	
//	@Autowired
//	private SqlSession sqlSession;
	
	//엘라스틱서치
	private String index = "audiolist";
	
	//몽고DB
	private String database = "audioDB";
	private String col = index;
	
	@GetMapping("/elasticData")
	public String getAllIndexInElastic(Model model) {
		SearchHit[] searchHits = elasticDao.getAllIndex(index);
		elasticDao.close();
		
		model.addAttribute("result", searchHits);
		return "elasticData";
	}
	
	@GetMapping("/mongoData")
	public String insertElasticIndexToMongo() {
		mongoDao.insertElasticIndex(database, col, index);
		mongoDao.close();
		elasticDao.close();
		
		return "/mongoData";
	}
	
//	@GetMapping("/postgreData")
//	public String insertElasticIndexToPostgre() {
//		return "/postgreData";
//	}
}
