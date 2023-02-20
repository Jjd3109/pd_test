<h1>Api구성환경</h1>
 <p>-language : JAVA
 <p>-Framwork : SpringBoot(maven)
 <p>-Database : mysql
<p>

<h2>1-1 Controller입니다.</h2>

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
 
 <h2>1-2 service입니다.</h2>


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
	
 <h2>1-3 dao & xml 부분입니다.</h2>
 
	public List<loginVO> check(String name) {
		String mapperId = "heroMapper.checkData";
		List<loginVO> data = session.selectList(mapperId, name); 
		return data;
	}
 <p>
 
 	<select id="checkData" resultType="loginVo">
		select si.USER_ID, li.LAST_AC_DT, li.TOKEN, si.MOBILE_TYPE 
		from test.superhere_info si
		join test.login_info li 
		on si.ID = li.USER_ID
		where si.USER_ID  = #{name}
		ORDER BY li.id desc limit 1;
	</select>

	
<hr>
<h2>결과값</h2>
<h3> 보내주신 csv파일의 컬럼이 테이블값과 너무 달라서, 과제로 내주신 테이블값은 그대로 두고, 임의로 데이터값을 넣고 진행하였습니다.</h3>
<h2>1. 접속기록이 있는 데이터 조회결과 나오는 값입니다.
<p></p>
<img width="960" alt="1" src="https://user-images.githubusercontent.com/100771092/219953696-b944e442-4561-48ac-9388-8f1aa2483da3.PNG">
<h3>쿼리문에서 내림차순으로 바꿔서, 최근 접속한 시간의 접속기록이 있는 데이터 값을 조회하였습니다.
<p></p>
<h2>2. 접속기록이 없는 데이터 조회결과 나오는 값입니다.
<p></p>
<img width="959" alt="캡처2" src="https://user-images.githubusercontent.com/100771092/219953924-a3ff8483-826c-4514-b3e1-48e76042c958.PNG">
<p></p>
<h2>3. 임의로 넣은 SUPERHERE_INFO 의 값입니다.
<img width="960" alt="HERR_INFO" src="https://user-images.githubusercontent.com/100771092/219953974-80062c3b-9df2-4cbc-87cf-b4efa87c219c.png">

