package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

@Component
public class FeedBackPojo {

	private int Id;
	private String feedBack;
	private BatchPojo batchPojo;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	
}
