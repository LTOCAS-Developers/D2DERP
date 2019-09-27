package com.d2derp.oep.dao.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.Questions;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer> {


}
