package com.d2derp.oep.service.questionstopic;

import java.util.List;

import com.d2derp.oep.pojo.QuestionsTopicPojo;

public interface QuestionsTopicService {
	
	void save(QuestionsTopicPojo questionsTopicPojo);
	
	List<QuestionsTopicPojo> listQuestionsTopic();

	QuestionsTopicPojo findQuestionstopic(int id);

	void deleteQuestionsTopic(int id);

	QuestionsTopicPojo editQuestionstopic(QuestionsTopicPojo questionsTopicPojo);

}
