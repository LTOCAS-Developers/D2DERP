package com.d2derp.oep.service.feedbackAsso;

import java.util.List;

import com.d2derp.oep.entity.Course;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.FeedBackAssoPojo;

public interface FeedBackAssoSerive {

	void createFeedBackAsso(FeedBackAssoPojo feedBackAssoPojo);

	List<CoursePojo> getFeedBackAsso(int id);

	void deleteFeedBackAsso(FeedBackAssoPojo feedBackAssoPojo);



}
