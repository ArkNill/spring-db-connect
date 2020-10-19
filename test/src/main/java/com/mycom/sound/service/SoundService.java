package com.mycom.sound.service;

import java.util.List;

import com.mycom.sound.dto.Phone;
import com.mycom.sound.dto.UserInfo;

public interface SoundService {
	int insert(Phone phone);

	int delete(List<String> list);

	Phone select(Phone phone);

	List<Phone> select();
	
	UserInfo select(UserInfo user);
}
