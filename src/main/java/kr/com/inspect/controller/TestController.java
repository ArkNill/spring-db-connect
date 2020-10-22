package kr.com.inspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.repository.TestRepository;

@Controller
public class TestController {
	@Autowired
	private TestRepository dataRepository;
	
	@GetMapping("/test")
	public String moveTestPage() {
		return "test/testPage";
	}
	
	@GetMapping("/mongoTest")
	public String testMongo() {
		dataRepository.testMongoInsert();
		return "test/mongoTest";
	}
}
