package kr.com.inspect.dao;

import java.util.List;

import kr.com.inspect.dto.Sound;

public interface TestDao {
	public List<Sound> testPostgreFind();
	public void insertPostgre(List<Sound> soundList);
}
