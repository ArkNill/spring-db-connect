package kr.com.inspect.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.inspect.dao.PostgreDao;
import kr.com.inspect.dto.Sound;
import kr.com.inspect.mapper.PostgreMapper;

@Repository
public class PostgreDaoImpl implements PostgreDao {
	@Autowired
	private PostgreMapper postgreMapper;
	
	@Override
	public List<Sound> testPostgreFind() {
		return postgreMapper.findAll();
	}

	@Override
	public void insertPostgre(List<Sound> soundList) {
		for(Sound sound : soundList) {
			postgreMapper.insertValue(sound);
		}
	}
}
