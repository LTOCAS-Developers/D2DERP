package com.d2derp.oep.service.feedbackquestions;

import java.util.List;


import com.d2derp.oep.pojo.FeedBackQuestionsPojo;

public interface FeedBackQuestionService {

	void createFeedBackQuestions(FeedBackQuestionsPojo feedBackQuestionsPojo);

	List<FeedBackQuestionsPojo> getFeedBackQuestions();

	FeedBackQuestionsPojo getFeedBackQuestionById(int id);

	FeedBackQuestionsPojo putFeedBackQuestion(FeedBackQuestionsPojo feedBackQuestionsPojo);

	void deleteFeedBackQuestion(int id);

}
