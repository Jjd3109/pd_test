package com.myhome.web.login.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class loginVO {
	//loginDTO에 담아서 보내기 ! 
	private String user_id;
	private String token;
	private Long last_ac_dt;
	private String mobile_type;
	

	public String getLast_ac_dt() {
		//날짜를 date식으로 변환
		Date date = new Date(last_ac_dt); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String formatDate = dateFormat.format(last_ac_dt);
		return formatDate;
	}
	public void setLast_ac_dt(Long last_ac_dt) {
		this.last_ac_dt = last_ac_dt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getMobile_type() {
		return mobile_type;
	}
	public void setMobile_type(String mobile_type) {
		this.mobile_type = mobile_type;
	}

	
	

}
