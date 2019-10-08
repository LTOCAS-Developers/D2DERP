package com.d2derp.oep.dao.questionstopic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2derp.oep.entity.QuestionsTopic;

public interface QuestionsTopicDao extends JpaRepository<QuestionsTopic, Integer>{

	List<QuestionsTopic> findByCourseId(int id);
}
