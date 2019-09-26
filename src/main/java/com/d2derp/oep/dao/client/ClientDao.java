package com.d2derp.oep.dao.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client,Integer> {

}
