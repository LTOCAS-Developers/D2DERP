package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserTypePojo {

	private int id;
	private String userType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}	

}
