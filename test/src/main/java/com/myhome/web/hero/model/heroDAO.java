package com.myhome.web.hero.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.web.login.model.loginVO;

@Repository
public class heroDAO {
	
	@Autowired
	private SqlSession session = null;
	
	public List<loginVO> check(String name) {
		String mapperId = "heroMapper.checkData";
		List<loginVO> data = session.selectList(mapperId, name); 
		return data;
	}

}
