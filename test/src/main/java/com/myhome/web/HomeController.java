package com.myhome.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.web.hero.service.heroService;
import com.myhome.web.login.model.loginVO;


@Controller
public class HomeController {

	@Autowired
	heroService service = new heroService();
	
	
	@ResponseBody
	@GetMapping(value="/test")
	public ResponseEntity<Map<String, Object>> test(Model model //, @RequestParam ("name") String name
			) {
		//특정아이디조회 ex)
		String name = "XD";
		
		//아이디로 가장 최근 접속일 조회
		Map<String, Object> result = service.check(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
