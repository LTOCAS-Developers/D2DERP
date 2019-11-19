package com.d2derp.oep.service.feedback;

import java.util.List;

import com.d2derp.oep.pojo.FeedBackPojo;

public interface FeedBackService {

	void save(FeedBackPojo feedBackPojo);

	List<FeedBackPojo> listFeedBack();

	FeedBackPojo listById(int id);

	FeedBackPojo editFeedBack(FeedBackPojo feedBackPojo);

	void deleteFeedBack(int id);

	

}
