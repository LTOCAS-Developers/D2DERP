package com.d2derp.oep.service.questions;

import java.util.List;

import com.d2derp.oep.entity.Questions;
import com.d2derp.oep.pojo.CourseTopicIdsPojo;
import com.d2derp.oep.pojo.QuestionsPojo;

public interface QuestionsService {

	void saveQuestions(QuestionsPojo questionsPojo);

	List<QuestionsPojo> getQuestions();

	QuestionsPojo getQuestionsById(int id);

	void deleteQuestions(int id);

	
	QuestionsPojo editQuestion(QuestionsPojo questionsPojo);

	List<Questions> getQuestionByCourseAndTopic(CourseTopicIdsPojo courseTopicIds);

}
