package com.d2derp.oep.pojo;

import java.util.ArrayList;
import java.util.List;

public class FeedBackAssoPojo {

	private int feedBack_Id;
	private  List<Integer> courseId = new ArrayList<>();
	public int getFeedBack_Id() {
		return feedBack_Id;
	}
	public void setFeedBack_Id(int feedBack_Id) {
		this.feedBack_Id = feedBack_Id;
	}
	public List<Integer> getCourseId() {
		return courseId;
	}
	public void setCourseId(List<Integer> courseId) {
		this.courseId = courseId;
	}
	
	
	
	
}
