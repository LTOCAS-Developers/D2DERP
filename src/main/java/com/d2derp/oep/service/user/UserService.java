package com.d2derp.oep.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.d2derp.oep.entity.User;
import com.d2derp.oep.pojo.UserPojo;


public interface UserService {
	void save( UserPojo userPojo);

	List<UserPojo> listUser();

	UserPojo findUser(int id);

	void deleteUser(int id);

	UserPojo editUser(UserPojo userPojo);
	}
