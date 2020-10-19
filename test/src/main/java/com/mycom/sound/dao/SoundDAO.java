package com.mycom.sound.dao;

import java.util.List;

import com.mycom.sound.dto.Phone;
import com.mycom.sound.dto.UserInfo;

public interface SoundDAO {
	int insert(Phone phone);

	int delete(List<String> list);

	Phone select(Phone phone);

	List<Phone> select();

	UserInfo select(UserInfo user);
}
