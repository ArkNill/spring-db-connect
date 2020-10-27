package kr.com.inspect.dao;

import java.util.List;

import kr.com.inspect.dto.Sound;

public interface PostgreDao {
	public List<Sound> getTable();
	public void insertPostgre(String index);
}
