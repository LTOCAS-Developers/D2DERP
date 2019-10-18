package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

@Component
public class QuestionPaperPojo {

	private int questionPaperId;
	private String name;
	
	public int getQuestionPaperId() {
		return questionPaperId;
	}
	public void setQuestionPaperId(int questionPaperId) {
		this.questionPaperId = questionPaperId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
