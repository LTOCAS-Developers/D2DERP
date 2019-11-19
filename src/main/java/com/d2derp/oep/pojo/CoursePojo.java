package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

import com.d2derp.oep.entity.FeedBack;

@Component
public class CoursePojo {

	
	private int id;
	private String name;
	private FeedBack feedBack;
	
	
	public FeedBack getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
