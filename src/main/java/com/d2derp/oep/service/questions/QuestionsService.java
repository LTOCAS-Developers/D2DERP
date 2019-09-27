package com.d2derp.oep.service.questions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.d2derp.oep.pojo.QuestionsPojo;

@Service
public interface QuestionsService {

	void saveQuestions(QuestionsPojo questionsPojo);

	List<QuestionsPojo> getQuestions();

	QuestionsPojo getQuestionsById(int id);

	void deleteQuestions(int id);

	QuestionsPojo editQuestion(QuestionsPojo questionsPojo);

}
