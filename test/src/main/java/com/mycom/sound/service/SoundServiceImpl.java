package com.mycom.sound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.sound.dao.SoundDAO;
import com.mycom.sound.dto.Phone;
import com.mycom.sound.dto.UserInfo;

@Service
public class SoundServiceImpl implements SoundService{
	
	@Autowired
	private SoundDAO iPhoneDAO;
	
	@Transactional
	public int insert(Phone phone) {
		return iPhoneDAO.insert(phone);
	}
	
	@Transactional
	public int delete(List<String> list) {
		return iPhoneDAO.delete(list);
	}

	public Phone select(Phone phone) {
		return iPhoneDAO.select(phone);
	}

	public List<Phone> select() {
		return iPhoneDAO.select();
	}

	public UserInfo select(UserInfo user) {
		return iPhoneDAO.select(user);
	}
}
