package com.mycom.sound.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.sound.dto.Phone;
import com.mycom.sound.dto.UserInfo;

@Repository
public class SoundDaoImpl implements SoundDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NS = "sql.pms.mapper.";
	
	public int insert(Phone phone) {
		return sqlSession.insert(NS+"insert", phone);
	}

	public int delete(List<String> list) {
		return sqlSession.delete(NS+"delete", list);
	}

	public Phone select(Phone phone) {
		System.out.println(sqlSession.selectOne(NS+"select", phone));
		return sqlSession.selectOne(NS+"select", phone);
	}

	public List<Phone> select() {	
		return sqlSession.selectList(NS+"select",null);
	}

	public UserInfo select(UserInfo user) {
		return sqlSession.selectOne(NS+"selectUser", user);
	}	
}








