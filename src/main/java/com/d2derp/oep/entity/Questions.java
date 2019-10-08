package com.d2derp.oep.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Questions {
	@Id
	@GeneratedValue
	@Column(name = "Questions_ID")
	private int questionNumber;

	private String questions;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;

	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;

	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionsTopic questionsTopic;

	@OneToMany(mappedBy = "questionsQuespaperAssoId.questions", cascade = CascadeType.ALL)
	private List<QuestionsQuespaperAsso> questionsQuespaperAsso = new ArrayList<QuestionsQuespaperAsso>();

	public List<QuestionsQuespaperAsso> getQuestionsQuespaperAsso() {
		return questionsQuespaperAsso;
	}

	public void setQuestionsQuespaperAsso(List<QuestionsQuespaperAsso> questionsQuespaperAsso) {
		this.questionsQuespaperAsso = questionsQuespaperAsso;
	}

	public QuestionsTopic getQuestionsTopic() {
		return questionsTopic;
	}

	public void setQuestionsTopic(QuestionsTopic questionsTopic) {
		this.questionsTopic = questionsTopic;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
