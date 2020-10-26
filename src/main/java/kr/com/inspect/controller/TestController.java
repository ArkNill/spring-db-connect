package kr.com.inspect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.com.inspect.dao.TestDao;
import kr.com.inspect.dto.Sound;

@Controller
public class TestController {
	@Autowired
	private TestDao testDao;
	
	@GetMapping("/test")
	public String moveTestPage() {
		return "test/testPage";
	}
	
	@GetMapping("/postgreData")
	public String testPostgre(Model model) {
		List<Sound> soundList = testDao.testPostgreFind();
		for(Sound sound : soundList) {
			System.out.println(sound.getTitle());
		}
		model.addAttribute("result", soundList);
		return "postgreData";
	}
}
