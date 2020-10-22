package kr.com.inspect.controller;

import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.service.DataService;
import kr.com.inspect.repository.DataRepository;

@Controller
public class DataController {
	@Autowired
	private DataRepository dataRepository;
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/testPage")
	public String moveTestPage() {
		return "testPage";
	}
	
	@GetMapping("/elasticData")
	public String getAllIndexInElastic(Model model) {
		SearchHit[] searchHits = dataRepository.getAllIndexInElastic();
		model.addAttribute("result", searchHits);
		return "elasticData";
	}
	
	@GetMapping("/mongoData")
	public String insertElasticIndexToMongo() {
		dataRepository.insertElasticIndexToMongo();
		return "/mongoData";
	}
}
