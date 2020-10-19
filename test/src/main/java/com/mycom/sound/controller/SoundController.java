package com.mycom.sound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.sound.dto.Phone;
import com.mycom.sound.service.SoundService;

@RestController
public class SoundController {	
	
	@Autowired
	private SoundService iPhoneService;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록폼");
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			iPhoneService.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 성공");
			return "Result";
		}catch(RuntimeException e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return "Error";
		}
	}
}





