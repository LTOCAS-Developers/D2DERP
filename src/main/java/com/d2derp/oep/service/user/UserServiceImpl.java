package com.d2derp.oep.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.client.ClientDao;
import com.d2derp.oep.dao.user.UserDao;
import com.d2derp.oep.dao.user.UserTypeDao;
import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.User;
import com.d2derp.oep.entity.UserType;
import com.d2derp.oep.pojo.ClientPojo;
import com.d2derp.oep.pojo.UserPojo;
import com.d2derp.oep.pojo.UserTypePojo;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserTypeDao userTypeDao;

	@Autowired
	private ClientDao clientdao;
	
	Date date=new Date();

	public UserTypeDao getUserTypeDao() {
		return userTypeDao;
	}

	public void setUserTypeDao(UserTypeDao userTypeDao) {
		this.userTypeDao = userTypeDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(UserPojo userPojo) {

		User user = new User();
		Client client = null;
		UserType userType = null;
		ClientPojo clientPojo = new ClientPojo();

		if (userPojo.getClientPojo().getId() == 0 | userPojo.getClientPojo() == null ) {
			System.out.println("iiii");
			userPojo.getClientPojo().setId(1);
			client = clientdao.getOne(1);

		} else {
			client = clientdao.getOne(userPojo.getClientPojo().getId());

		}
		if (userPojo.getUserTypePojo().getId() == 0 | userPojo.getUserTypePojo() == null) {
			userPojo.getUserTypePojo().setId(1);
			userType = userTypeDao.getOne(1);
		} else {
			userType = userTypeDao.getOne(userPojo.getClientPojo().getId());

		}

		user.setCpass(userPojo.getCpass());
		user.setCreatedDate(date);
		user.setEmail(userPojo.getEmail());
		user.setFirstName(userPojo.getFirstName());
		user.setIpAddress(111111);
		user.setLastModifiedDate(date);
		user.setLastName(userPojo.getLastName());
		user.setMobileNumber(userPojo.getMobileNumber());
		user.setPass(userPojo.getPass());
		user.setSno(1);
		user.setStatus("ok");

		user.setUserType(userType);
		user.setClient(client);
		System.out.println(user.getClient().getCompanyName());
		userDao.save(user);

	}

	public List<UserPojo> listUser() {

		List<UserPojo> userPojoList = new ArrayList();
		List<User> userList = userDao.findAll();
		ClientPojo clientPojo = new ClientPojo();
		UserTypePojo userTypePojo = new UserTypePojo();


		for (int i = 0; i < userList.size(); i++) {

			User user = userList.get(i);
			UserPojo userPojo = new UserPojo();

			userPojo.setCpass(user.getCpass());
			userPojo.setCreatedDate(date);
			userPojo.setEmail(user.getEmail());
			userPojo.setFirstName(user.getFirstName());
			userPojo.setId(user.getId());
			userPojo.setIpAddress(user.getIpAddress());
			userPojo.setLastModifiedDate(date);
			userPojo.setLastName(user.getLastName());
			userPojo.setMobileNumber(user.getMobileNumber());
			userPojo.setPass(user.getPass());
			userPojo.setSno(user.getSno());
			userPojo.setStatus(user.getStatus());
			
			clientPojo.setCompanyName(user.getClient().getCompanyName());
			clientPojo.setId(user.getClient().getId());
			userTypePojo.setUserType(user.getUserType().getUserType());
			userTypePojo.setId(user.getUserType().getId());
			
			userPojo.setClientPojo(clientPojo);
			userPojo.setUserTypePojo(userTypePojo);

			userPojoList.add(userPojo);
		}

		return userPojoList;
	}

	public UserPojo findUser(int id) {

		Optional<User> user = userDao.findById(id);
		UserPojo userPojo = new UserPojo();
		ClientPojo clientPojo = new ClientPojo();
		UserTypePojo userTypePojo = new UserTypePojo();

		clientPojo.setCompanyName(user.get().getClient().getCompanyName());
		clientPojo.setId(user.get().getClient().getId());
		userTypePojo.setUserType(user.get().getUserType().getUserType());
		userTypePojo.setId(user.get().getUserType().getId());

		userPojo.setUserTypePojo(userTypePojo);
		userPojo.setClientPojo(clientPojo);

		userPojo.setCpass(user.get().getCpass());
		userPojo.setEmail(user.get().getEmail());
		userPojo.setFirstName(user.get().getFirstName());
		userPojo.setId(user.get().getId());
		userPojo.setLastName(user.get().getLastName());
		userPojo.setMobileNumber(user.get().getMobileNumber());
		userPojo.setPass(user.get().getPass());
		userPojo.setSno(user.get().getSno());
		userPojo.setStatus(user.get().getStatus());
		userPojo.setIpAddress(user.get().getIpAddress());
		userPojo.setCreatedDate(user.get().getCreatedDate());
		userPojo.setLastModifiedDate(user.get().getLastModifiedDate());
		
		return userPojo;

	}

	@Override
	public void deleteUser(int id) {

		userDao.deleteById(id);

	}

	public UserPojo editUser(UserPojo userPojo) {
		// TODO Auto-generated method stub

		Optional<User> user = userDao.findById(userPojo.getId());

		user.get().setFirstName(userPojo.getFirstName());
		user.get().setCpass(userPojo.getCpass());
		user.get().setEmail(userPojo.getEmail());
		user.get().setId(userPojo.getId());
		user.get().setIpAddress(userPojo.getIpAddress());
		user.get().setLastModifiedDate(userPojo.getLastModifiedDate());
		user.get().setLastName(userPojo.getLastName());
		user.get().setMobileNumber(userPojo.getMobileNumber());
		user.get().setPass(userPojo.getPass());
		user.get().setSno(userPojo.getSno());
		user.get().setStatus(userPojo.getStatus());

		Client client = user.get().getClient();
		client.setCompanyName(userPojo.getClientPojo().getCompanyName());
		client.setId(userPojo.getClientPojo().getId());

		UserType userType = user.get().getUserType();
		userType.setId(userPojo.getUserTypePojo().getId());
		userType.setUserType(userPojo.getUserTypePojo().getUserType());
		return userPojo;
	}

}
