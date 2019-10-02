package com.d2derp.oep.dao.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

	 
}
