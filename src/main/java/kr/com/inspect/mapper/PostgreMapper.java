package kr.com.inspect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.com.inspect.dto.Sound;

@Mapper
public interface PostgreMapper {
	
	@Insert("INSERT INTO public.audiolist"+
							"(category,title,company,content)"+
							"VALUES(#{category},#{title},#{company},#{content});")
	public void insertValue(Sound sound);
	
	@Select("SELECT * FROM audiolist")
	public List<Sound> findAll();
}
