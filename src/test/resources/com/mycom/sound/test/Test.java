package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.MyProduct;

public class Test {
		
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();

		MyProduct vo = new MyProduct("드럼 세탁기", "삼성", 900000);
		System.out.println("DB 들어가기 전 : "+vo.getId()); //0. 입력 안 됨.

		//session.insert("ProductMapper.addProduct", vo); //DB에 값 집어넣고 + id값 자동 생성 + 그 값을 vo에 setting
		System.out.println("INSERT OK!!");
		System.out.println("DB 들어간 후 : "+vo.getId());

		session.commit();

		System.out.println("===============================================");
		MyProduct rvo = session.selectOne("ProductMapper.findByProductName", "드럼");
		System.out.println(rvo);

		System.out.println("===============================================");
		List<MyProduct> list = session.selectList("ProductMapper.findByProductName", "세탁기");
		for(MyProduct v : list) System.out.println(v);

		System.out.println("===============================================");
		List<MyProduct> list2 = session.selectList("ProductMapper.findProducts");
		System.out.println(list2);
	}
}
