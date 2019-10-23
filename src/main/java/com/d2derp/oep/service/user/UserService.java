package com.d2derp.oep.service.user;

import java.util.List;

import com.d2derp.oep.pojo.UserPojo;


public interface UserService {
	void save( UserPojo userPojo);

	List<UserPojo> listUser();

	UserPojo findUser(int id);

	void deleteUser(int id);

	UserPojo editUser(UserPojo userPojo);
	}
