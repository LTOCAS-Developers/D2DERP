package com.d2derp.oep.dao.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client,Integer> {

	@Query("Select c from Client c where c.companyName like %:name%")	  
	List<Client> findBySearchTerm(String name);
}
