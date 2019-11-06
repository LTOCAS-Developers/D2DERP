package com.d2derp.oep.controller.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.pojo.FeedBackPojo;
import com.d2derp.oep.service.feedback.FeedBackService;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	private FeedBackService feedBackService;

	public FeedBackService getFeedBackService() {
		return feedBackService;
	}

	public void setFeedBackService(FeedBackService feedBackService) {
		this.feedBackService = feedBackService;
	}
	
	@PostMapping(value="/save")
	public void createFeedBack(@RequestBody FeedBackPojo feedBackPojo) {
		feedBackService.createFeedBack(feedBackPojo);
	}
}
