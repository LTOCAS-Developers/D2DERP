package com.d2derp.oep.pojo;

public class FeedBackQuestionsPojo {

	private int id;
	private String questions;	
	private CoursePojo coursePojo;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public CoursePojo getCoursePojo() {
		return coursePojo;
	}
	public void setCoursePojo(CoursePojo coursePojo) {
		this.coursePojo = coursePojo;
	}
	
	
}
