package com.d2derp.oep.pojo;

import java.util.ArrayList;
import java.util.List;

public class QuestionsQuespaperAssoPojo {

	private int questionPaperId;
	private List<Integer> questionsId =new ArrayList<>();
	public int getQuestionPaperId() {
		return questionPaperId;
	}
	public void setQuestionPaperId(int questionPaperId) {
		this.questionPaperId = questionPaperId;
	}
	public List<Integer> getQuestionsId() {
		return questionsId;
	}
	public void setQuestionsId(List<Integer> questionsId) {
		this.questionsId = questionsId;
	}
	
	}
