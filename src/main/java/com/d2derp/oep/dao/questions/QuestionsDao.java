package com.d2derp.oep.dao.questions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2derp.oep.entity.Questions;

public interface QuestionsDao extends JpaRepository<Questions, Integer> {

}
