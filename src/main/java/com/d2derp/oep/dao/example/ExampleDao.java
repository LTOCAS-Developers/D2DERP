package com.d2derp.oep.dao.example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.EntityA;




@Repository

public interface ExampleDao extends JpaRepository<EntityA, Integer> {

}

