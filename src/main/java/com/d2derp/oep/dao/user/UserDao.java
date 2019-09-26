package com.d2derp.oep.dao.user;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

	 
}
