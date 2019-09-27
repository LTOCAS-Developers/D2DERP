package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

@Component
public class QuestionsTopicPojo {

	private int id;
	private String topic;
	private CoursePojo coursePojo;
	public CoursePojo getCoursePojo() {
		return coursePojo;
	}
	public void setCoursePojo(CoursePojo coursePojo) {
		this.coursePojo = coursePojo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
}
