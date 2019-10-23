package com.d2derp.oep.dao.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.Batch;

@Repository
public interface BatchDao extends JpaRepository<Batch, Integer> {

}
