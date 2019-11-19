package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;


@Component
public class FeedBackPojo {

	private int id;
	private String feedBack;
	private BatchPojo batchPojo;
	private CoursePojo coursePojo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CoursePojo getCoursePojo() {
		return coursePojo;
	}
	public void setCoursePojo(CoursePojo coursePojo) {
		this.coursePojo = coursePojo;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public BatchPojo getBatchPojo() {
		return batchPojo;
	}
	public void setBatchPojo(BatchPojo batchPojo) {
		this.batchPojo = batchPojo;
	}

	@Override
	public String toString() {
		return "FeedBackPojo [id=" + id + ", feedBack=" + feedBack + ", batchPojo=" + batchPojo + "]";
	}
	
}
