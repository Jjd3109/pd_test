package com.myhome.web.hero.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myhome.web.hero.model.heroDAO;
import com.myhome.web.login.model.loginVO;

@Service
public class heroService {

	@Autowired
	heroDAO dao = new heroDAO();

	public Map<String, Object>  check(String name) {
		
		List<loginVO> data = dao.check(name);

		Map<String, Object> result = new HashMap<>();
		
		//데이터값을 담아준다
		result.put("data", data);
		
		if(!data.isEmpty()) {
			//아이디 값이 있을경우 
			result.put("result", "success");			
		}else {
			//아이디값이 없을경우
			result.put("result", "There is no record");	
		}
		
		return result;
		
	}
	


}
