package kr.com.inspect.controller;

import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.ElasticDao;
import kr.com.inspect.dao.MongoDao;

@Controller
public class ElasticController {
	@Autowired
	private ElasticDao elasticDao;
	
	//엘라스틱서치
	private String index = "audiolist";
	
	/* 엘라스틱서치 페이지 이동 */
	@GetMapping("/elasticPage")
	public String moveToElasticPage() {
		return "elasticsearch/elasticPage";
	}
	
	/* 엘라스틱서치 특정 인덱스 가져오기 */
	@GetMapping("/getElasticIndex")
	public String getElasticIndex(Model model) {
		SearchHit[] searchHits = elasticDao.getIndex(index);
		//elasticDao.close();
		
		model.addAttribute("result", searchHits); 
		return "elasticsearch/getIndex";
	}
}
