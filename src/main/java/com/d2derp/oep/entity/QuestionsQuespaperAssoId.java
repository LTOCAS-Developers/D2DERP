package com.d2derp.oep.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class QuestionsQuespaperAssoId implements Serializable {

	@ManyToOne(cascade = CascadeType.ALL)
	private Questions questions;
	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionPaper questionPaper;
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}
	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
	
}
